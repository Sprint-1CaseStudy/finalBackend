package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserNotFoundException;

public interface IUserService {

	public UserEntity addUser(UserEntity user) throws UserNotFoundException;
	public UserEntity signIn(UserEntity user) throws UserNotFoundException;
	public String signOut();
	public UserEntity changePassword(UserEntity user) throws UserNotFoundException;
	

}
