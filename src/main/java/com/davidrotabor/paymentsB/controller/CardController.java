package com.davidrotabor.paymentsB.controller;

import com.davidrotabor.paymentsB.entity.Card;
import com.davidrotabor.paymentsB.service.CardService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @QueryMapping
    private List<Card> allCards() {
        return cardService.getAllCards();
    }

    @QueryMapping
    private Card cardById(@Argument Long cardId) {
        return cardService.getCardById(cardId);
    }

    @MutationMapping
    private Card addCard(@Argument
                         String cardNumber,
                         @Argument String cardCvc,
                         @Argument String cardType,
                         @Argument String cardHolderId,
                         @Argument String cardHolderName,
                         @Argument String expiryDate) {

        return cardService.addCard(cardNumber, cardCvc, cardType, cardHolderId, cardHolderName, expiryDate);
    }

}
