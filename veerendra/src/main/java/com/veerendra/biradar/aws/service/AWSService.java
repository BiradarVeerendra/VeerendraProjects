package com.veerendra.biradar.aws.service;

import com.veerendra.biradar.exception.VeerAppException;

public interface AWSService {

    void uploadFileToS3(String data) throws VeerAppException;

    String generatePresignedUrl(String objectKey) throws VeerAppException;

    void downloadAS3File(String objectKey) throws VeerAppException;

    void deleteS3File(String objectKey) throws VeerAppException;
}
