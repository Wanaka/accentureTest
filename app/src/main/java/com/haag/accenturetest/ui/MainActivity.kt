package com.haag.accenturetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.haag.accenturetest.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.main_toolbar.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar as Toolbar)
    }
}