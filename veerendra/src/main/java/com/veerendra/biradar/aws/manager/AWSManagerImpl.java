package com.veerendra.biradar.aws.manager;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.veerendra.biradar.exception.VeerAppException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AWSManagerImpl implements AWSManager {

    @Value("${aws.s3AccessKey}")
    String s3AccessKey;

    @Value("${aws.s3SecretKey}")
    String s3SecretKey;

    @Override
    public AmazonS3 awsS3Client() throws VeerAppException {

        try {
            return AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(
                            new BasicAWSCredentials(s3AccessKey, s3SecretKey))
                    )
                    .withRegion(Regions.AP_SOUTH_1)
                    .build();
        } catch (Exception e) {
            throw VeerAppException.standardError();
        }
    }

}
