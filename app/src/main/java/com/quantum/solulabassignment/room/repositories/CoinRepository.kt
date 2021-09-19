package com.quantum.solulabassignment.room.repositories

import androidx.lifecycle.LiveData
import com.quantum.solulabassignment.room.dao.CoinsDao
import com.quantum.solulabassignment.models.CoinModel

class CoinRepository ( private  val coinsDao: CoinsDao) {

    val allCoins:LiveData<List<CoinModel>> =coinsDao.getAllCoins()

    suspend fun insert(coinModel: CoinModel){
        coinsDao.insert(coinModel)
    }

    suspend fun deleteAll(){
        coinsDao.deleteAllCoins()
    }
}