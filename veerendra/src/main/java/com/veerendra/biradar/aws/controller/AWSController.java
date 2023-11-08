package com.veerendra.biradar.aws.controller;

import com.veerendra.biradar.api_req_res.response.ResponseDTO;
import com.veerendra.biradar.api_req_res.response.VeerAppResponseBody;
import com.veerendra.biradar.aws.dto.AWSUploadRequest;
import com.veerendra.biradar.aws.service.AWSService;
import com.veerendra.biradar.exception.VeerAppException;
import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AWSController {

    AppLog LOG = AppLogger.getAppLog(AWSController.class);

    @Autowired
    AWSService awsService;

    @RequestMapping(value = "/aws/s3/upload-data", method = RequestMethod.POST)
    public ResponseDTO uploadDataToS3(@RequestBody AWSUploadRequest awsUploadRequest) {
        try {
            awsService.uploadFileToS3(awsUploadRequest.getData());
            return VeerAppResponseBody.successResponse(new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while uploading the given data to S3", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while uploading the given data to S3", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }
    }

    @RequestMapping(value = "/aws/s3/get-pre-signed-url", method = RequestMethod.POST)
    public ResponseDTO generatePresignedUrl(@RequestBody AWSUploadRequest awsUploadRequest) {
        try {
            String preSignedUrl = awsService.generatePresignedUrl(awsUploadRequest.getObjectKey());
            return VeerAppResponseBody.successResponse(preSignedUrl);
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while generating pre-signed-url", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while pre-signed-url ", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }
    }

    @RequestMapping(value = "/aws/s3/download-file", method = RequestMethod.POST)
    public ResponseDTO downloadS3File(@RequestBody AWSUploadRequest awsUploadRequest) {
        try {
            awsService.downloadAS3File(awsUploadRequest.getObjectKey());
            return VeerAppResponseBody.successResponse(new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while downloading s3-file", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while downloading s3-file", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }
    }

    @RequestMapping(value = "/aws/s3/delete-file", method = RequestMethod.POST)
    public ResponseDTO deleteS3File(@RequestBody AWSUploadRequest awsUploadRequest) {
        try {
            awsService.deleteS3File(awsUploadRequest.getObjectKey());
            return VeerAppResponseBody.successResponse(new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while downloading s3-file", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while downloading s3-file", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }
    }
}
