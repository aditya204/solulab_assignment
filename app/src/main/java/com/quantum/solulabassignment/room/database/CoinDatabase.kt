package com.quantum.solulabassignment.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.quantum.solulabassignment.room.dao.CoinsDao
import com.quantum.solulabassignment.models.CoinModel


@Database(entities = arrayOf(CoinModel::class),version = 1,exportSchema = false)
abstract class CoinDatabase : RoomDatabase(){
    abstract fun getCoinsDao(): CoinsDao

    companion object{

        @Volatile
        private var INSTANCE:CoinDatabase?=null

        fun getDatabase(context: Context):CoinDatabase{
            return INSTANCE ?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CoinDatabase::class.java,
                    "coin_database"
                ).build()
                INSTANCE=instance
                instance

            }
        }

    }

}