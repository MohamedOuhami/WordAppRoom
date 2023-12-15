package com.v01d.wordgame.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WordDAO {

    @Insert
    suspend fun insert(word: Word)

    @Update
    suspend fun update(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("SELECT * FROM word_table ORDER BY wordId DESC")
    fun getAll(): LiveData<List<Word>>

    @Query("SELECT * FROM word_table WHERE wordId = :id")
    fun getById(id: Int): LiveData<Word>
}
