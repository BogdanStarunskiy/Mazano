package com.example.mazano.ui.games.db


import android.content.Context
import androidx.room.*
import com.example.mazano.models.games.GamesEntity
import com.example.mazano.ui.games.db.dao.GamesDao

@Database(entities = [GamesEntity::class], version = 1)
abstract class GamesDatabase: RoomDatabase() {
    abstract fun getDao():GamesDao

    companion object{
        private var database:GamesDatabase? = null
        @Synchronized
        fun getInstance(context: Context):GamesDatabase{
            return if (database==null){
                database = Room.databaseBuilder(context, GamesDatabase::class.java, "gamesData").build()
                database as GamesDatabase
            }else{
                database as GamesDatabase
            }

        }
    }

}