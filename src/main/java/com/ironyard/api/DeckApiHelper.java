package com.ironyard.api;

import com.ironyard.dto.DeckOfCards;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by rohanayub on 2/22/17.
 */
public class DeckApiHelper {

    public DeckOfCards getDeckofCards(){
        RestTemplate restTemplateCard = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards myDeck = (DeckOfCards) response.getBody();
        return myDeck;
    }
    public DeckOfCards getShuffledDeck(){
        RestTemplate restTemplateCard = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards myDeck = (DeckOfCards) response.getBody();
        String deckID = myDeck.getDeckId();

        HttpEntity responseShuffle = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/"+ deckID+"/shuffle/\n", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards myShuffledDeck = (DeckOfCards) responseShuffle.getBody();
        return myShuffledDeck;

    }
    public DeckOfCards openNewDeck(){
        RestTemplate restTemplateCard = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards myDeck = (DeckOfCards) response.getBody();
        String oldDeckID = myDeck.getDeckId();
        System.out.println(oldDeckID);

        HttpEntity responseOpenDeck = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/\n", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards myDeckOpen = (DeckOfCards) responseOpenDeck.getBody();
        String newDeckId = myDeckOpen.getDeckId();
        System.out.println(newDeckId);
        return myDeckOpen;

    }
    public DeckOfCards drawCards(){
        RestTemplate restTemplateDrawCard = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplateDrawCard.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards myDeck = (DeckOfCards) response.getBody();
        String deckId = myDeck.getDeckId();

        HttpEntity responseDrawnCard = restTemplateDrawCard.exchange("https://deckofcardsapi.com/api/deck/"+deckId+"/draw/?count=2\n", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards drawnCards = (DeckOfCards) responseDrawnCard.getBody();
        return drawnCards;


    }
    public DeckOfCards partialDeck(){
        RestTemplate restTemplatePartialDeck = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

        HttpEntity entity = new HttpEntity(headers);

        HttpEntity response = restTemplatePartialDeck.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH/\n", HttpMethod.GET, entity, DeckOfCards.class);
        DeckOfCards partialCards = (DeckOfCards) response.getBody();
        return partialCards;
    }
}
