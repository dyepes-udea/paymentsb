package com.davidrotabor.paymentsB.service;

import com.davidrotabor.paymentsB.entity.Card;
import com.davidrotabor.paymentsB.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Flight not found"));
    }

    public Card addCard(String cardNumber, String cardCvc, String cardType,  String cardHolderId, String cardHolderName, String expiryDate) {
        Card card = new Card();

        card.setCardNumber(cardNumber);
        card.setCardCvc(cardCvc);
        card.setCardType(cardType);
        card.setCardHolderName(cardHolderId);
        card.setCardHolderName(cardHolderName);
        card.setExpiryDate(expiryDate);

        return cardRepository.save(card);
    }

}
