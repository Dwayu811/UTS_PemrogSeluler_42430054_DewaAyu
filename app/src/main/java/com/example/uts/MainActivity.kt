package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNamaDosen: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNamaDosen = findViewById(R.id.etNamaDosen)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val nama = etNamaDosen.text.toString().trim()

            if (nama.isEmpty()) {
                etNamaDosen.error = getString(R.string.error_empty_name)
                return@setOnClickListener
            }

            val intent = Intent(this, PanelActivity::class.java)
            intent.putExtra("NAMA_DOSEN", nama)
            startActivity(intent)
        }
    }
}