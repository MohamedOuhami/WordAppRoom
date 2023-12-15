package com.v01d.wordgame.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey(autoGenerate = true)
    var wordId: Int = 0,
    @ColumnInfo(name = "wordText")
    var wordText: String = ""
) {
    // This secondary constructor is annotated with @Ignore to eliminate it from consideration by Room
    @Ignore
    constructor(wordText: String) : this(0, wordText)
}
