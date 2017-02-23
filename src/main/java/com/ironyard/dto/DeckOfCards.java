package com.ironyard.dto;

/**
 * Created by rohanayub on 2/22/17.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeckOfCards {
    @Id
    @GeneratedValue
    private Long id;
    private Boolean success;
    @JsonProperty (value = "deck_id")
    private String deckId;
    private Boolean shuffled;
    private Integer remaining;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getDeckId() {
        return deckId;
    }

    public void setDeckId(String deckId) {
        this.deckId = deckId;
    }

    public Boolean getShuffled() {
        return shuffled;
    }

    public void setShuffled(Boolean shuffled) {
        this.shuffled = shuffled;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
//    @Override
//    public String toString() {
//        return "{ success=" + success +
//                ", deck_id ='" + deckId +
//                ", shuffled=" + shuffled +
//                ", remaining=" + remaining +'\'' +
//                '}';
//    }
@Override
public String toString() {
    return "DeckOfCards{" +
            "id=" + id +
            ", success=" + success +
            ", deckId='" + deckId + '\'' +
            ", shuffled=" + shuffled +
            ", remaining=" + remaining +
            ", cards=" + cards +
            '}';
}
}
