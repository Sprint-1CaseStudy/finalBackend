package com.example.onlinesportshopee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserNotFoundException;
import com.example.onlinesportshopee.services.IUserService;

 
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/onlinesportshopee")
public class UserController {
    
    static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserService iUserService;
    
    @PostMapping("/login/add-user")
    public  ResponseEntity<UserEntity> addUser(@RequestBody UserEntity User)throws UserNotFoundException{
        LOGGER.info("add-user URL is opened");
        LOGGER.info("addUserEntity() is initiated");
        UserEntity user = iUserService.addUser(User);
        LOGGER.info("addUser() has executed");
        return new ResponseEntity<UserEntity>(user,HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/login/signin")
    public ResponseEntity<UserEntity> signIn(@RequestBody UserEntity User) throws UserNotFoundException
    {
        LOGGER.info("signIn URL is opened");
        LOGGER.info("signIn() is initiated");
        UserEntity user = iUserService.signIn(User);
        LOGGER.info("signIn() has Executed");
        return new ResponseEntity<UserEntity>(user,HttpStatus.ACCEPTED);
    }
    
    
    @GetMapping("/login/signout")
    public ResponseEntity<String> signOut() throws UserNotFoundException
    {
        LOGGER.info("sign-out URL is opened");
        LOGGER.info("signout() is initiated");
        String signout = iUserService.signOut(); 
        LOGGER.info("signout() has Executed");
        return new ResponseEntity<String>(signout,HttpStatus.ACCEPTED);
    }
    
    @PutMapping("/login/changepassword")
    public ResponseEntity<UserEntity> changePassword(@RequestBody UserEntity User) throws UserNotFoundException
    {
        LOGGER.info("changepassword URL is opened");
        LOGGER.info("changepassword() is initiated");
        UserEntity user = iUserService.changePassword(User);
        LOGGER.info("changepassword() has Executed");
        return new ResponseEntity<UserEntity>(user,HttpStatus.ACCEPTED);
    }    
    
}