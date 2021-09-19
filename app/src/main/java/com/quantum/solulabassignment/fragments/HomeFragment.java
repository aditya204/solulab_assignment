package com.quantum.solulabassignment.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.quantum.solulabassignment.Adapters.CoinAdapter;
import com.quantum.solulabassignment.R;
import com.quantum.solulabassignment.models.CoinModel;
import com.quantum.solulabassignment.viewModels.CoinViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

     RecyclerView recyclerView;
     CoinAdapter coinAdapter;
     List<CoinModel> coinModelsList;
     CoinViewModel coinViewModel;


     ImageButton notification,mail,search;
     ImageView profileImage;
     LinearLayout ll_scan,ll_sell;
     TextView seeall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate( R.layout.fragment_home, container, false );

        recyclerView=view.findViewById( R.id.home_frag_recycler );
        notification=view.findViewById( R.id.notification_image_btn );
        mail=view.findViewById( R.id.mail_image_btn );
        search=view.findViewById( R.id.search_image_btn );
        profileImage=view.findViewById( R.id.profileImage );
        ll_scan=view.findViewById( R.id.scan_Ll );
        ll_sell=view.findViewById( R.id.sell_Ll );
        seeall=view.findViewById( R.id.see_all_txt );

        setClickListners(view.getContext());
        coinModelsList=new ArrayList<>(  );
        coinViewModel= new ViewModelProvider(this).get(CoinViewModel.class);

        coinViewModel.getAllCoins().observe( (LifecycleOwner) view.getContext( ), new Observer<List<CoinModel>>( ) {
            @Override
            public void onChanged(List<CoinModel> coinModels) {
                if(coinModels!=null){
                    coinModelsList=coinModels;

                    setCoinAdapter(view.getContext());


                }

            }
        } );


        return view;
    }


    private void setCoinAdapter(Context context){
        LinearLayoutManager linearLayoutManager= new GridLayoutManager(context,3 );
        recyclerView.setLayoutManager( linearLayoutManager );
        coinAdapter=new CoinAdapter( coinModelsList );
        recyclerView.setAdapter( coinAdapter );

        coinAdapter.notifyDataSetChanged();

    }

    private void setClickListners(Context context){
        mail.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );
        notification.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );
        search.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );
        profileImage.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );
        ll_sell.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );
        ll_scan.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );
        seeall.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                showToast(context);
            }
        } );

    }

    private void showToast(Context context){
        Toast.makeText( context, "TODO //:- implement functionality", Toast.LENGTH_SHORT ).show( );
    }
}