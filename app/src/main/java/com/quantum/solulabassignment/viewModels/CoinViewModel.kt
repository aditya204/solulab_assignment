package com.quantum.solulabassignment.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.quantum.solulabassignment.room.database.CoinDatabase
import com.quantum.solulabassignment.models.CoinModel
import com.quantum.solulabassignment.room.repositories.CoinRepository
import kotlinx.coroutines.launch


class CoinViewModel (application: Application) :AndroidViewModel(application) {

    val allCoins: LiveData<List<CoinModel>>
    val repository:CoinRepository

    init {
        val dao=CoinDatabase.getDatabase(application).getCoinsDao()
        repository= CoinRepository(dao)
        allCoins=repository.allCoins

    }


   fun addCoins(coinModel: CoinModel) = viewModelScope.launch {
       repository.insert(coinModel)
   }

    fun deleteAll() =viewModelScope.launch {
        repository.deleteAll()
    }










}