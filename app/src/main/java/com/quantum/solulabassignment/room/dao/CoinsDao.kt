package com.quantum.solulabassignment.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.quantum.solulabassignment.models.CoinModel

@Dao
interface CoinsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(coin:CoinModel)



    @Query("Select * from coinsTable order by id ASC")
    fun getAllCoins():LiveData<List<CoinModel>>

    @Query("DELETE FROM coinsTable")
    fun deleteAllCoins()
}