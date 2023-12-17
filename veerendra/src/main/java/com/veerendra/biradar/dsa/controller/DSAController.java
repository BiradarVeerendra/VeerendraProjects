package com.veerendra.biradar.dsa.controller;

import com.veerendra.biradar.dsa.service.DSAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DSAController {

    @Autowired
    DSAService dsaService;

    @PostMapping("/bobble/sort")
    public void bobbleSort(){

        dsaService.bobbleSort();

    }


}
