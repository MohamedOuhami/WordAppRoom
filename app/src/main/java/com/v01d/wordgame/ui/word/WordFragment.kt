package com.v01d.wordgame.ui.word

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.v01d.wordgame.R
import com.v01d.wordgame.adapters.WordItemAdapter
import com.v01d.wordgame.data.WordDatabase
import com.v01d.wordgame.databinding.FragmentWordBinding

class WordFragment : Fragment() {
    private var _binding:FragmentWordBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = WordFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordBinding.inflate(inflater,container,false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = WordDatabase.getInstance(application).wordDAO
        val viewModelFactory = WordViewModelFactory(dao)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(WordViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return view
    }


}