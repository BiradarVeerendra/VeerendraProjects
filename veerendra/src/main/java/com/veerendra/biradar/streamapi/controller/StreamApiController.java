package com.veerendra.biradar.streamapi.controller;

import com.veerendra.biradar.streamapi.service.StreamApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamApiController {

    @Autowired
    StreamApiService streamApiService;


}
