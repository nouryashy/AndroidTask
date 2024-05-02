package com.example.androidtask.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidtask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mABinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mABinding = ActivityMainBinding.inflate(layoutInflater)
    }
}