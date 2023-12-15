package com.v01d.wordgame.ui.word

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.v01d.wordgame.data.WordDAO

class WordViewModelFactory(private val dao:WordDAO):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)){
            return WordViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}