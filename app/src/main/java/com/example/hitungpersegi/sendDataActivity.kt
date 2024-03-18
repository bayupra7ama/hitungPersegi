package com.example.hitungpersegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class sendDataActivity : AppCompatActivity() {

    companion object {
        val EXTRA_HITUNG = "extra_hitung"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_data)

        val hasil :TextView = findViewById(R.id.resultData)
        val move = intent.getStringExtra(EXTRA_HITUNG)
        hasil.text = move.toString()
    }
}