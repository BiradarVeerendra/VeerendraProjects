package com.veerendra.biradar.aws.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.veerendra.biradar.aws.manager.AWSManager;
import com.veerendra.biradar.exception.VeerAppException;
import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AWSServiceImpl implements AWSService {

    AppLog LOG = AppLogger.getAppLog(AWSServiceImpl.class);

    @Value("${aws.commonBucketName}")
    String commonBucketName;

    @Autowired
    AWSManager awsManager;

    /**
     * Upload String data to s3
     */
    @Override
    public void uploadFileToS3(String data) throws VeerAppException {

        try {
            /*Create Amazon S3 client*/
            AmazonS3 s3Client = awsManager.awsS3Client();

            /*String data to input stream*/
            byte[] fileContentByte = data.getBytes(StandardCharsets.UTF_8);
            InputStream fileInputStream = new ByteArrayInputStream(fileContentByte);

            /*Set meta data*/
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(fileContentByte.length);

            /*S3 object key*/
            String objectKey = "Veerendra/" + LocalDate.now() + "/" + LocalTime.now() + "/testFile.json";

            /*Here the data/file/attachment will be stored to S3*/
            PutObjectRequest request = new PutObjectRequest(
                    commonBucketName, objectKey, fileInputStream, metadata
            );

            /*Adding Tag details of an attachment*/
            List<Tag> tags = new ArrayList<>();
            tags.add(new Tag("type", "attachment"));
            tags.add(new Tag("subtype", "xyzDocument"));
            request.setTagging(new ObjectTagging(tags));

            /*upload data to s3*/
            s3Client.putObject(request);

        } catch (VeerAppException e) {
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            throw VeerAppException.standardError();
        }
    }

    /**
     * Generate pre-signed-url from given object key
     *
     * @return
     */
    @Override
    public String generatePresignedUrl(String objectKey) throws VeerAppException {

        try {
            //Optional* Set the pre-signed-url to expire after five hour.
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = expiration.getTime();
            expTimeMillis += 5000 * 60 * 60;
            expiration.setTime(expTimeMillis);

            //Generate the pre-signed-url.
            URL url = awsManager.awsS3Client().generatePresignedUrl(new GeneratePresignedUrlRequest(commonBucketName, objectKey)
                    .withMethod(HttpMethod.GET)
                    .withExpiration(expiration));

            //return url.toString();
            LOG.info("pre-signed-url is=" + url);
            return url.toExternalForm();
        } catch (SdkClientException e) {
            LOG.error("SdkClientException ", e);
            throw VeerAppException.internalServerError(e.getMessage(), new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException ", e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception ", e);
            throw VeerAppException.standardError();
        }
    }

    @Autowired
    public void downloadAS3File(String objectKey) throws VeerAppException {

        try {
            S3Object s3object = awsManager.awsS3Client().getObject(commonBucketName, objectKey);
            S3ObjectInputStream inputStream = s3object.getObjectContent();
            File file = new File("veerendra.extension");
            FileUtils.copyInputStreamToFile(inputStream, file);

            /*FileUtils.copyInputStreamToFile(
                    awsManager.awsS3Client()
                            .getObject(commonBucketName, objectKey)
                            .getObjectContent(),
                    new File("veerendra.extension")
            );*/
        } catch (IOException e) {
            LOG.error("IOException ", e);
            throw VeerAppException.internalServerError(e.getMessage(), new ArrayList<>());
        } catch (VeerAppException e){
            LOG.error("VeerAppException ", e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e){
            LOG.error("Exception ", e);
            throw VeerAppException.standardError();
        }
    }

}
