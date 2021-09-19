package com.quantum.solulabassignment.apis;

import com.quantum.solulabassignment.responses.CoinResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface coinApi {

    @GET("coinlist")
    Call<CoinResponse> getCoins();


}
