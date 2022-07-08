package com.example.mazano.ui.games.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mazano.models.games.GamesEntity
import com.example.mazano.models.games.GamesModelItem

@Dao
interface GamesDao {

    @Query("SELECT * FROM gamesEntity")
    fun getAllGames():LiveData<GamesEntity>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGame(gamesEntity: GamesEntity)
    @Update
    fun updateGame(gamesEntity: GamesEntity)
}