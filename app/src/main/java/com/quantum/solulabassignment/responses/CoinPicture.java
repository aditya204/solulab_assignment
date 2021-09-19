package com.quantum.solulabassignment.responses;

import com.google.gson.annotations.SerializedName;

public class CoinPicture {

    @SerializedName( "front" )
    CoinSide coinside;

    public CoinPicture(CoinSide coinside) {
        this.coinside = coinside;
    }

    public CoinSide getCoinside() {
        return coinside;
    }

    public void setCoinside(CoinSide coinside) {
        this.coinside = coinside;
    }
}
