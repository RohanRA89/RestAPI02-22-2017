package com.ironyard.controller;

import com.ironyard.api.DeckApiHelper;
import com.ironyard.dto.DeckOfCards;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rohanayub on 2/22/17.
 */
@RestController
public class RestControllers {
    @RequestMapping(path="/rest/getCards", method = RequestMethod.GET)
    public DeckOfCards getCurrentDeck(){
        DeckApiHelper helper = new DeckApiHelper();
        DeckOfCards currentDeck = helper.getDeckofCards();
        return currentDeck;

    }

    @RequestMapping(path="/rest/shuffleDeck", method = RequestMethod.GET)
    public  DeckOfCards getShuffledDeck(){
        return new DeckApiHelper().getShuffledDeck();
    }

    @RequestMapping (path="/rest/openNewDeck", method = RequestMethod.GET)
    public DeckOfCards getOpenedDeck(){
        return new DeckApiHelper().openNewDeck();
    }
    @RequestMapping(path="/rest/drawCards",method = RequestMethod.GET)
    public DeckOfCards getDrawnCards(){
        return new DeckApiHelper().drawCards();
    }

    @RequestMapping(path="/rest/partialDeck",method = RequestMethod.GET)
    public DeckOfCards getPartialDeck(){
        return new DeckApiHelper().partialDeck();
    }
}
