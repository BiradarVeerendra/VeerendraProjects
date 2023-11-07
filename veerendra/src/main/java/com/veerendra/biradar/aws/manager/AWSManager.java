package com.veerendra.biradar.aws.manager;

import com.amazonaws.services.s3.AmazonS3;
import com.veerendra.biradar.exception.VeerAppException;

public interface AWSManager {

    AmazonS3 awsS3Client() throws VeerAppException;

}
