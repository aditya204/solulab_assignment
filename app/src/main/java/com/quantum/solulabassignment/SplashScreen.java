package com.quantum.solulabassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.quantum.solulabassignment.apis.coinApi;
import com.quantum.solulabassignment.models.CoinModel;
import com.quantum.solulabassignment.networkRequests.AppExecutors;
import com.quantum.solulabassignment.responses.CoinResponse;
import com.quantum.solulabassignment.viewModels.CoinViewModel;
import com.quantum.solulabassignment.viewModels.SplashCoinViewModels;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashScreen extends AppCompatActivity {

   public static TextView textView;
    SplashCoinViewModels splashCoinViewModels;
    CoinViewModel coinViewModel;
    CoinRunnable coinRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );
        textView=findViewById( R.id.tv_retro );
        deleteAddPreviousCoins();

        splashCoinViewModels= new ViewModelProvider(this).get(SplashCoinViewModels.class);
        coinViewModel= new ViewModelProvider(this).get(CoinViewModel.class);
        splashCoinViewModels.makeApiCall();

        splashCoinViewModels.getCoinsObserver().observe( this, new Observer<List<CoinModel>>( ) {
            @Override
            public void onChanged(List<CoinModel> coinModels) {




                    for(int i=0;i<coinModels.size();i++){

                        coinViewModel.addCoins( coinModels.get( i ) );

                    }

                    Intent intent=new Intent( SplashScreen.this,MainActivity.class );

                    startActivity( intent );
                    finish();





            }
        } );







    }

    private void deleteAddPreviousCoins(){

        if(coinRunnable!=null){
            coinRunnable=null;
        }


        coinRunnable=new CoinRunnable(  );

        final Future<?> myHandler= AppExecutors.getInstance().networkIO().submit(coinRunnable);

        AppExecutors.getInstance().networkIO().schedule( new Runnable( ) {
            @Override
            public void run() {



                myHandler.cancel( true );

            }
        } ,2000, TimeUnit.MICROSECONDS);


    }


    private class CoinRunnable implements Runnable{

        @Override
        public void run() {
            coinViewModel.deleteAll();



        }
    }


}