package com.quantum.solulabassignment.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "coinsTable")
class CoinModel(
    @ColumnInfo(name = "title") val coinTitle:String,
    @ColumnInfo(name = "imageUrl") val coinImage:String,
    ) {

    @PrimaryKey(autoGenerate = true)
    var id=0
}