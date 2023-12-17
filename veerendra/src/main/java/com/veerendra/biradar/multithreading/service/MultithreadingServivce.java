package com.veerendra.biradar.multithreading.service;

import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import org.springframework.stereotype.Service;

@Service
public class MultithreadingServivce {

    AppLog LOG = AppLogger.getAppLog(MultithreadingServivce.class);

    public void workersThread(){

        LOG.info("Before thread starts");

        Thread t1 = new Thread(() -> {

            for (int i=0; i<=100; i++){
                LOG.info("users thread 1, count="+i);
            }

        });

        Thread t2 = new Thread(() -> {

            for (int i=0; i<=100; i++){
                LOG.info("users thread 2, count="+i);
            }

        });

        t1.start();
        t2.start();

        // join() this method is used to execute the down code,
        // once all the thread processed successfully.
        // if the below code is dependent on end of the thread task.
        try {
            t1.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOG.info("Before thread starts");

    }

    public void daemonThread() {

        LOG.info("Before Daemon thread starts");

        Thread t1 = new Thread(() -> {

            for (int i=0; i<=100; i++){
                LOG.info("Daemon thread 1, count="+i);
            }

        });

        Thread t2 = new Thread(() -> {

            for (int i=0; i<=10; i++){
                LOG.info("users/worker thread 2, count="+i);
            }

        });

        //we have to set the setDaemon thread to true, it's true by default
        //Basically it will get interrupted once all the other threads get completes their tasks.
        t1.setDaemon(true);

        t1.start();
        t2.start();

        // join() this method is used to execute the down code,
        // once all the thread processed successfully.
        // if the below code is dependent on end of the thread task.
        try {
            t1.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        LOG.info("Before thread starts");


    }
}
