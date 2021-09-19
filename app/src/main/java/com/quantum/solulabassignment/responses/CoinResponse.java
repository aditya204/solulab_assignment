package com.quantum.solulabassignment.responses;

import com.google.gson.annotations.SerializedName;

public class CoinResponse {

    int result;
    String msg;
    @SerializedName( "data" )
    CoinData coinData;

    public CoinResponse(int result, String msg, CoinData coinData) {
        this.result = result;
        this.msg = msg;
        this.coinData = coinData;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CoinData getCoinData() {
        return coinData;
    }

    public void setCoinData(CoinData coinData) {
        this.coinData = coinData;
    }
}
