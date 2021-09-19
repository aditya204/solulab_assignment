package com.quantum.solulabassignment.networkRequests;

import com.quantum.solulabassignment.apis.coinApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicy {

    static  Servicy servicey;
    final static  String  BASE_URL="https://demo3231717.mockable.io/";

    private  static Retrofit.Builder retrofitBuilder= new Retrofit.Builder()
            .baseUrl( BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() );

    private  static final Retrofit retrofit=retrofitBuilder.build();

    private static final coinApi coinapi= retrofit.create( coinApi.class );


    public static synchronized Servicy getInstance(){
        if(servicey==null){
            servicey=new Servicy();
        }
        return servicey;
    }


    public static coinApi getCoinapi(){
        return coinapi;
    }

}
