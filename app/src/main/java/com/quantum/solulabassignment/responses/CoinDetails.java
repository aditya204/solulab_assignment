package com.quantum.solulabassignment.responses;

import com.google.gson.annotations.SerializedName;

public class CoinDetails {

    String _id;
    String name;
    @SerializedName( "pictures" )
    CoinPicture coinPicture;

    public CoinDetails(String _id, String name, CoinPicture coinPicture) {
        this._id = _id;
        this.name = name;
        this.coinPicture = coinPicture;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoinPicture getCoinPicture() {
        return coinPicture;
    }

    public void setCoinPicture(CoinPicture coinPicture) {
        this.coinPicture = coinPicture;
    }
}
