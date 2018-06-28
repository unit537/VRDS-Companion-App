package com.dev.unit537.vrds_companion_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class YGOHubResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("card")
    @Expose
    private Card card;
    @SerializedName("cards")
    @Expose
    private ArrayList<String> cards;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public void setCards(ArrayList<String> cards) {
        this.cards = cards;
    }
}
