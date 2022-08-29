package com.juango.haystackchallenge.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.juango.haystackchallenge.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}