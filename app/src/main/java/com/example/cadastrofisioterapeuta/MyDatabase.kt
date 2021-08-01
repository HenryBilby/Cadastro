package com.example.cadastrofisioterapeuta

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Fisioterapeuta::class], version = 1)
abstract class MyDatabase : RoomDatabase(){
    abstract fun fisioterapeutaDao() : FisioterapeutaDAO
}

object MyDb {
    fun getInstance(context: Context) : MyDatabase =
        Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "my-database.db"
        ).build()
}