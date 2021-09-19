package com.quantum.solulabassignment.viewModels;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.quantum.solulabassignment.SplashScreen;
import com.quantum.solulabassignment.apis.coinApi;
import com.quantum.solulabassignment.models.CoinModel;
import com.quantum.solulabassignment.networkRequests.Servicy;
import com.quantum.solulabassignment.responses.CoinResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashCoinViewModels extends ViewModel {

    MutableLiveData<List<CoinModel>> coinList;

    public  SplashCoinViewModels (){
        coinList=new MutableLiveData<>(  );

    }

    public   MutableLiveData<List<CoinModel>> getCoinsObserver(){
        return coinList;
    }

    public void makeApiCall(){

        coinApi api= Servicy.getCoinapi();
        Call<CoinResponse> call=api.getCoins();

        call.enqueue( new Callback<CoinResponse>( ) {
            @Override
            public void onResponse(Call<CoinResponse> call, Response<CoinResponse> response) {
                CoinResponse coinResponse=response.body();

                int  result=coinResponse.getResult();

                if(result==1){
                    int result_per_page= coinResponse.getCoinData().getItemsPerPage();
                    //SplashScreen.textView.setText( result_per_page );
                    List<CoinModel> list=new ArrayList<>(  );

                    for(int i=0;i<result_per_page;i++){
                        String coin_name=coinResponse.getCoinData().getCoinDetails().get( i ).getName();
                        String coin_image="";
                                if(coinResponse.getCoinData().getCoinDetails().get( i ).getCoinPicture()!=null){
                                    coin_image=coinResponse.getCoinData().getCoinDetails().get( i ).getCoinPicture().getCoinside( ).getUrl( );
                                }

                        list.add( new CoinModel( coin_name,coin_image ) );

                    }





                    coinList.postValue( list );

                }else{

                    Log.v( "error","something went wrong");

                }







            }

            @Override
            public void onFailure(Call<CoinResponse> call, Throwable t) {
                Log.v( "error",t.getMessage());
            }
        } );

    }
}
