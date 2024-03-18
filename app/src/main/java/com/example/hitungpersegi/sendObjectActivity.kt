package com.example.hitungpersegi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class sendObjectActivity : AppCompatActivity() {

    companion object{
   const  val EXTRA_OBJECT = "extra_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_object)

        val tvResult :TextView = findViewById(R.id.resultObject)
        val objectRecived = if (Build.VERSION.SDK_INT>=33){

            intent.getParcelableExtra<buku>(EXTRA_OBJECT , buku::class.java)
        }else{
            @Suppress "DEPRECATION"
            intent.getParcelableExtra<buku>(EXTRA_OBJECT)
        }
        if (objectRecived != null){
            val text = "judul ${objectRecived.judul} ,\n pengarang : ${objectRecived.pengarang} ,\n halaman ${objectRecived.halaman}"
            tvResult.text = text
        }

    }
}