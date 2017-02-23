package com.ironyard;

import com.ironyard.dto.DeckOfCards;
import com.ironyard.dto.Quote;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestapiApplicationTests {

	@Test
	public void contextLoads() {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		System.out.println(quote.toString());
	}
	@Test
	public void contextLoadsTwo(){
		RestTemplate restTemplateCard = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");

		HttpEntity entity = new HttpEntity(headers);

		HttpEntity response = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1", HttpMethod.GET, entity, DeckOfCards.class);
		DeckOfCards myDeck = (DeckOfCards) response.getBody();

		System.out.println(myDeck.toString());

		String deckID = myDeck.getDeckId();

		HttpEntity responseShuffle = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/"+ deckID+"/shuffle/\n", HttpMethod.GET, entity, DeckOfCards.class);
		DeckOfCards myDeckShuffle = (DeckOfCards) responseShuffle.getBody();

		System.out.println(myDeckShuffle.toString());

		HttpEntity responseOpenDeck = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/\n", HttpMethod.GET, entity, DeckOfCards.class);
		DeckOfCards myDeckOpen = (DeckOfCards) responseOpenDeck.getBody();

		System.out.println(myDeckOpen.toString());

		HttpEntity responseDrawCard = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/"+deckID+"/draw/?count=2", HttpMethod.GET, entity, DeckOfCards.class);
		DeckOfCards drawnCards = (DeckOfCards) responseDrawCard.getBody();

		System.out.println(drawnCards.toString());

		HttpEntity responsePartialDeck = restTemplateCard.exchange("https://deckofcardsapi.com/api/deck/new/shuffle/?cards=AS,2S,KS,AD,2D,KD,AC,2C,KC,AH,2H,KH/\n", HttpMethod.GET, entity, DeckOfCards.class);
		DeckOfCards partialDeck = (DeckOfCards) responsePartialDeck.getBody();

		System.out.println(partialDeck.toString());
	}

}
