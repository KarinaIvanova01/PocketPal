package com.pocketpal.services.contracts;

import com.pocketpal.models.Card;
import com.pocketpal.models.User;

import java.util.List;

public interface CardService {

    Card getCardById(Long id);

    List<Card> getAllCards();

    void saveCard(Card card);

    Long updateCard(User user, Long cardId, Card card);
}
