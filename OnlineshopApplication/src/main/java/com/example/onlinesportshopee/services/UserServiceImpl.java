package com.example.onlinesportshopee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.controller.UserController;
import com.example.onlinesportshopee.dao.IUserRepository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {
    
    static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserRepository Userrepo;

    @Override
    public UserEntity addUser(UserEntity user) throws UserNotFoundException {
        LOGGER.info("addUser() service is initiated");
        UserEntity userEnti;
        if( user.getGmail() == "" || user.getPassword() == null) 
        	throw new UserNotFoundException("Username or password cannot be empty");	
        else {
                userEnti=Userrepo.save(user);    
        }
        LOGGER.info("addUser() service has executed");
        return userEnti;
    }
    
    @Override
    public UserEntity signIn(UserEntity user) throws UserNotFoundException {
        LOGGER.info("signin() service is initiated");
        UserEntity useridrepo = Userrepo.findByGmail(user.getGmail());
        if (useridrepo == null)
        {
            String usernotfound = "No user found by the userid "+user.getId();
            throw new UserNotFoundException(usernotfound);
        }
        else 
        {
            if(user.getGmail().equals(useridrepo.getGmail()) && user.getPassword().equals(useridrepo.getPassword())) 
            {
                LOGGER.info("signin() service has Executed");
                return useridrepo;
            }
            else {
                throw new UserNotFoundException("User name and password are invalid");
            }
        }
    }

 

    @Override
    public String signOut() {
        LOGGER.info("signout() service is initiated");
        return "Signout Successfully";
    }

 

    @Override
    public UserEntity changePassword(UserEntity user) throws UserNotFoundException {
        LOGGER.info("changepassword() service is initiated");
        UserEntity changePassword = Userrepo.findByGmail(user.getGmail());
        if(changePassword == null)
        {
            String usernotfound = "No user found by the userid ";
            throw new UserNotFoundException(usernotfound);
        }
        else
        {
        	if(changePassword.getUsername().equals(user.getUsername()))
        	{
        		Userrepo.updateById(changePassword.getId(),user.getPassword());
        		LOGGER.info("changepassword() service has Executed");
                return Userrepo.findById(changePassword.getId()).orElse(null);
        	}
        	else
        	{
        		throw new UserNotFoundException("enter valid username");
        	}
        }
        
    }
}