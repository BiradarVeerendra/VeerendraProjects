package com.veerendra.biradar.dsa.service;

import org.springframework.stereotype.Service;

@Service
public class DSAService {

    public void bobbleSort() {

        int[] arr = {1, 2, 6, 4, 3, 5};

        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < (arr.length - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println(arr[i]);
        }
    }
}
