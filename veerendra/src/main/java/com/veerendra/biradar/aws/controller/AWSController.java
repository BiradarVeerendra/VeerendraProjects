package com.veerendra.biradar.aws.controller;

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

    @RequestMapping(value = "/aws/s3/upload", method = RequestMethod.POST)
    public void uploadDataToS3(@RequestBody AWSUploadRequest awsUploadRequest) throws VeerAppException {
        try {
            awsService.uploadFileToS3(awsUploadRequest.getData());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while uploading the given data to S3", e);
            throw VeerAppException.internalServerError(e.getMessage(), new ArrayList<>());
        } catch (Exception e) {
            LOG.error("Exception while uploading the given data to S3", e);
            throw VeerAppException.standardError();
        }
    }
}
