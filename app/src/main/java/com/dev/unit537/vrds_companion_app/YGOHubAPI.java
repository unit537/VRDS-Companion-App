package com.dev.unit537.vrds_companion_app;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface YGOHubAPI {
    static final String BASE_URL = "https://www.ygohub.com/api/";
    static final String ALL_CARDS = "https://www.ygohub.com/api/all_cards";
    static final String CARD_BY_NAME = "https://www.ygohub.com/api/card_info?name=";
    static final String CARD_BY_PASSCODE = "https://www.ygohub.com/api/get_card_from_passcode?passcode=";
    static final String NEW_CARDS = "https://www.ygohub.com/api/new_cards?num_cards=";
    static final String ALL_SETS = "https://www.ygohub.com/api/all_sets";
    static final String SET_BY_NAME = "https://www.ygohub.com/api/set_info?name=";
    static final String SET_ABBREVIATIONS = "https://www.ygohub.com/api/get_card_set_abbreviations";

    @Headers("Content-Type: application/json")
    @GET(ALL_CARDS)
    Call<YGOHubResponse> getAllCardNames();

    @Headers("Content-Type: application/json")
    @GET(CARD_BY_NAME)
    Call<YGOHubResponse> getCardByName(@Query("name") String cardName);

    @Headers("Content-Type: application/json")
    @GET(CARD_BY_PASSCODE + "{passcode}")
    Call<YGOHubResponse> getCardByPasscode(@Query("passcode") String passcode);
}