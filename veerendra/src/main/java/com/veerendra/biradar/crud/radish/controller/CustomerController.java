//package com.veerendra.biradar.crud.radish.controller;
//
//import com.veerendra.biradar.crud.radish.dto.Customer;
//import com.veerendra.biradar.crud.radish.repo.RedisCrudRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class CustomerController {
//
//    @Autowired
//    private RedisCrudRepo userRepository;
//
//    @PostMapping("/save")
//    public Customer createUser(@RequestBody Customer user) {
//        return userRepository.save(user);
//    }
//
//    @GetMapping("/{id}")
//    public Customer getUser(@PathVariable String id) {
//        return userRepository.findById(id).orElse(null);
//    }
//}
//
