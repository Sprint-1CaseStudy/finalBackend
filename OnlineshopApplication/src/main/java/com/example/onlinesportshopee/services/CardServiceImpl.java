package com.example.onlinesportshopee.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.ICardRepository;
import com.example.onlinesportshopee.entities.CardEntity;

@Service
public class CardServiceImpl implements ICardService{
	
	static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);
	
	static String cardNotFound = "No card found in given Id";
	
	static String validateSuccessful = "Validation Successful";
	
	@Autowired
	private ICardRepository cardRepository;
	
	@Override
	public CardEntity addCard(CardEntity card) {
		LOGGER.info("addCard() service is initiated");
		CardEntity addCard = cardRepository.save(card);
		LOGGER.info("addCard() service has executed");
		return addCard;
	}

	@Override
	public CardEntity removeCard(Long id) {
		LOGGER.info("removeCard() service is initiated");
	    CardEntity deleteCard = cardRepository.findById(id).get();
	    cardRepository.delete(deleteCard);
	    LOGGER.info("removeCard() service has executed");
	    return deleteCard;
	}

	@Override
	public CardEntity updateCard(Long id, CardEntity card) {
		LOGGER.info("updateCard() service is initiated");
		CardEntity updateCard = cardRepository.findById(id).get();
		updateCard = cardRepository.save(card);
		LOGGER.info("updateCard() service has executed");
		return updateCard;
	}

	@Override
	public CardEntity getCardDetails(Long id) {
		LOGGER.info("getCardDetails() service is initiated");
		CardEntity getCardDetails = cardRepository.findById(id).get();
		LOGGER.info("getCardDetails() service has executed");
		return getCardDetails;
	}

	@Override
	public List<CardEntity> getAllCards(Long id) {
		LOGGER.info("getAllCards() service is initiated");
		List<CardEntity> getAllCards = cardRepository.findByCustId(id);
		LOGGER.info("getAllCards() service has executed");
		return getAllCards;
	}	

}
