package com.v01d.wordgame.ui.word

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.v01d.wordgame.R
import com.v01d.wordgame.UpdatexViewModel

class UpdatexFragment : Fragment() {

    companion object {
        fun newInstance() = UpdatexFragment()
    }

    private lateinit var viewModel: UpdatexViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_updatex, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UpdatexViewModel::class.java)
        // TODO: Use the ViewModel
    }

}