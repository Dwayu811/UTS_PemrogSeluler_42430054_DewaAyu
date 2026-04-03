package com.example.uts
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etNamaDosen: EditText
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNamaDosen = findViewById(R.id.etNamaDosen)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val nama = etNamaDosen.text.toString()

            val intent = Intent(this, PanelActivity::class.java)
            intent.putExtra("NAMA_DOSEN", nama)
            startActivity(intent)
        }
    }
}