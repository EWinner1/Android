package com.ew.hello.pack1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ew.hello.R

class UICostomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_costom)
        supportActionBar?.hide()
    }
}