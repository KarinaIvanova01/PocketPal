package com.pocketpal.services;

import com.pocketpal.exceptions.AuthorizationException;
import com.pocketpal.models.Card;
import com.pocketpal.models.User;
import com.pocketpal.repositories.CardRepository;
import com.pocketpal.services.contracts.CardService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pocketpal.constants.Constants.PERMISSION_ERROR;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;


    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card getCardById(Long id) {
       return cardRepository.getReferenceById(id);
    }

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }
    @Override
    public void saveCard(Card card){
         cardRepository.save(card);
    }
    @Override
    public Long updateCard(User user, Long cardId, Card card){
        checkIfHavePermission(user,card);
        try{
            Card oldCard = getCardById(cardId);
            oldCard.setNumber(card.getNumber());
            oldCard.setHolder(card.getHolder());
            oldCard.setCheckNumber(card.getCheckNumber());
            oldCard.setCardType(card.getCardType());
            oldCard.setExpirationDate(card.getExpirationDate());
          // cardRepository.updateCard(cardId);

        }catch (EntityNotFoundException e){
            cardRepository.save(card);
        }
        return cardRepository.updateCard(cardId);
    }

    private void checkIfHavePermission(User user, Card card){
        if (user.getId() != card.getUser().getId() || !(user.isAdmin())){
            throw new AuthorizationException(PERMISSION_ERROR);

        }
    }
}
