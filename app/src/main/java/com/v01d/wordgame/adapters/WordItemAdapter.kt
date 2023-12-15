package com.v01d.wordgame.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.v01d.wordgame.data.Word
import com.v01d.wordgame.data.WordDAO
import com.v01d.wordgame.databinding.WordItemBinding
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.v01d.wordgame.databinding.FragmentWordBinding
import com.v01d.wordgame.ui.word.WordFragmentDirections
import com.v01d.wordgame.ui.word.WordViewModel
import kotlinx.coroutines.launch

class WordItemAdapter(private val wordDao: WordDAO,private val viewModel: WordViewModel,
    private val navigator: NavController) : RecyclerView.Adapter<WordItemAdapter.WordItemViewHolder>() {

    var data = listOf<Word>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = WordItemBinding.inflate(layoutInflater, parent, false)
        val binding2 = FragmentWordBinding.inflate(layoutInflater, parent, false)
        binding.dao = wordDao
        return WordItemViewHolder(binding,binding2, wordDao,viewModel,navigator)
    }

    override fun onBindViewHolder(holder: WordItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size

    class WordItemViewHolder(val binding: WordItemBinding,
                             val binding2: FragmentWordBinding,
                             private val wordDao: WordDAO,
                             private val viewModel:WordViewModel,
                             private val navigator:NavController) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Word) {
            binding.word = item
            binding.deleteBtn.setOnClickListener {
                viewModel.deleteWord(item)
            }
            binding.updateBtn.setOnClickListener {
                Log.d("Word id",item.wordId.toString())
//                viewModel.newWord = item.wordText
                val action = WordFragmentDirections.actionWordFragmentToUpdatexFragment(item.wordId)
                navigator.navigate(action)

            }
        }
    }
}