package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserNotFoundException;

public class UserValidationimpl {
	
	public static UserEntity validateUser(UserEntity user) throws UserNotFoundException {
			if(user.getUsername() != null)
			{
				if(user.getPassword() != null)
				{
					return user;
				}
				else throw new UserNotFoundException("Password cannot be empty");
			}
			else throw new UserNotFoundException("Username cannot be empty");
	}	
}
