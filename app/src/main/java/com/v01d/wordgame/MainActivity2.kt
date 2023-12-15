package com.v01d.wordgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.v01d.wordgame.ui.word.WordFragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.word_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, WordFragment.newInstance())
                .commitNow()
        }
    }
}