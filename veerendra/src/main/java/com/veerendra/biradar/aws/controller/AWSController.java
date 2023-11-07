package com.veerendra.biradar.aws.controller;

import com.veerendra.biradar.aws.dto.AWSUploadRequest;
import com.veerendra.biradar.aws.service.AWSService;
import com.veerendra.biradar.exception.VeerAppException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AWSController {

    @Autowired
    AWSService awsService;

    Logger LOG = LogManager.getLogger(AWSController.class);

    @RequestMapping(value = "/aws/s3/upload", method = RequestMethod.POST)
    public void uploadDataToS3(@RequestBody AWSUploadRequest awsUploadRequest) throws VeerAppException {
        try {
            System.out.println("1==="+awsUploadRequest.getData());
            LOG.info("HI HOW ARE YOU ? 111 ");
            awsService.uploadFileToS3(awsUploadRequest.getData());
            System.out.println(awsUploadRequest.getData());
            LOG.info("HI HOW ARE YOU ? ");
        } catch (VeerAppException e) {
            throw VeerAppException.catchVeerAppError(e);
        }
    }
}
