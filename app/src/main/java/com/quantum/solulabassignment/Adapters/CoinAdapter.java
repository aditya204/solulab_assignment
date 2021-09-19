package com.quantum.solulabassignment.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.quantum.solulabassignment.R;
import com.quantum.solulabassignment.models.CoinModel;

import java.util.ArrayList;
import java.util.List;

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolder> {

    List<CoinModel> coinModels;

    public CoinAdapter(List<CoinModel> coinModels) {
        this.coinModels = coinModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.coin_item,parent,false );
        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String image=coinModels.get( position ).getCoinImage();
        String name=coinModels.get( position ).getCoinTitle();

        holder.title.setText( name );
        holder.setData( image );



    }

    @Override
    public int getItemCount() {
        if(coinModels.size()>=10){
            return 10;
        }else{
            return coinModels.size();

        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            imageView=itemView.findViewById( R.id.coin_image );
            title=itemView.findViewById( R.id.coin_title );



        }

        private void setData(String image){
            Glide.with( itemView.getContext() ).load( image ).into( imageView );

        }


    }


}
