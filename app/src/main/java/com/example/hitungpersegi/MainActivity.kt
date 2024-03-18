package com.example.hitungpersegi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var panjang : EditText
    private lateinit var lebar : EditText
    private lateinit var luas : TextView
    private lateinit var hitung : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        panjang = findViewById(R.id.lenght)
        lebar = findViewById(R.id.width)
        luas = findViewById(R.id.luas)
        hitung = findViewById(R.id.hitung)
        val pindah : Button = findViewById(R.id.sendDataIntent)
        val btnSendObject : Button = findViewById(R.id.sendObject)
        pindah.setOnClickListener(this)

        hitung.setOnClickListener(this)
        btnSendObject.setOnClickListener(this)


        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            luas.text = result
        }


    }

    override fun onClick(View: View?) {
       when(View?.id) {
           R.id.hitung -> {

               val inputPanjang = panjang.text.toString().trim()
               val inputLebar = lebar.text.toString().trim()
               var isEmptyField = false

               if (inputPanjang.isEmpty()) {
                   isEmptyField = true
                   panjang.error = "ini tidak boleh kosong"
               }
               if (inputLebar.isEmpty()) {
                   isEmptyField = true
                   lebar.error = "ini tidak boleh kosong"
               }
               if (!isEmptyField) {
                   val hasil = inputPanjang.toDouble() * inputLebar.toDouble()
                   luas.text = hasil.toString()


               }

           }R.id.sendDataIntent->{
               val moveIntent = Intent(this@MainActivity, sendDataActivity::class.java)
                moveIntent.putExtra(sendDataActivity.EXTRA_HITUNG , luas.text.toString())
           startActivity(moveIntent)
       }
           R.id.sendObject ->{
               val buku = buku(
                   "Dilan 1990", "Dilan ",223
               )
               val sendObjetIntent = Intent(this@MainActivity, sendObjectActivity::class.java)
               sendObjetIntent.putExtra(sendObjectActivity.EXTRA_OBJECT,buku)
               startActivity(sendObjetIntent)
           }

       }


        }

    companion object{
        val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,luas.text.toString())
    }
}

