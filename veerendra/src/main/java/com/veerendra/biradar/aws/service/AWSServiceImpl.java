package com.veerendra.biradar.aws.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.veerendra.biradar.aws.manager.AWSManager;
import com.veerendra.biradar.exception.VeerAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class AWSServiceImpl implements AWSService {

    @Value("${aws.commonBucketName}")
    String commonBucketName;
    @Autowired
    AWSManager manager;

    @Override
    public void uploadFileToS3(String data) throws VeerAppException {

        try {
            AmazonS3 s3Client = manager.awsS3Client();

            byte[] fileContentByte = data.getBytes(StandardCharsets.UTF_8);
            InputStream fileInputStream = new ByteArrayInputStream(fileContentByte);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(fileContentByte.length);

            String objectKey = "Veerendra/" + LocalDate.now() + "/" + LocalTime.now() + "/testFile.json";
            s3Client.putObject(new PutObjectRequest(
                    commonBucketName, objectKey, fileInputStream, metadata
            ));

        } catch (VeerAppException e) {
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            throw VeerAppException.standardError();
        }
    }

}
