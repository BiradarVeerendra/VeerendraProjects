package com.veerendra.biradar.multithreading.controller;


import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import com.veerendra.biradar.multithreading.service.MultithreadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultithreadingController {

    AppLog LOG = AppLogger.getAppLog(MultithreadingController.class);

    @Autowired
    MultithreadingService multithreadingServivce;

    @GetMapping("/thread/workers")
    public void usersThreadExample(){

        multithreadingServivce.workersThread();

    }

    @GetMapping("/thread/daemon")
    public void daemonThreadExample(){

        multithreadingServivce.daemonThread();

    }

    @GetMapping("/thread/synchronized")
    public void syncronizedBlock(){

        multithreadingServivce.synchronizedBlock();

    }


}
