package com.bakanito.quotesmvvm.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bakanito.quotesmvvm.data.database.dao.QuoteDao
import com.bakanito.quotesmvvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}