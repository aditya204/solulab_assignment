package com.quantum.solulabassignment.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinData {
    int totalItems;
    int startIndex;
    int itemsPerPage;
    @SerializedName( "list" )
    List<CoinDetails> coinDetails;

    public CoinData(int totalItems, int startIndex, int itemsPerPage, List<CoinDetails> coinDetails) {
        this.totalItems = totalItems;
        this.startIndex = startIndex;
        this.itemsPerPage = itemsPerPage;
        this.coinDetails = coinDetails;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public List<CoinDetails> getCoinDetails() {
        return coinDetails;
    }

    public void setCoinDetails(List<CoinDetails> coinDetails) {
        this.coinDetails = coinDetails;
    }
}
