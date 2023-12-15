package com.v01d.wordgame.ui.word

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.v01d.wordgame.data.Word
import com.v01d.wordgame.data.WordDAO
import kotlinx.coroutines.launch

class WordViewModel(val dao:WordDAO) : ViewModel() {
    var newWord = ""
    val words = dao.getAll()
    fun addWord(){
        viewModelScope.launch {
            val word = Word()
            word.wordText = newWord
            dao.insert(word)
            Log.d("All Words from SOurce ====", words.value.toString())
        }
    }

    fun deleteWord(word:Word){
        viewModelScope.launch {
            dao.delete(word)
            Log.d("All Words from SOurce ====", words.value.toString())
        }
    }
}