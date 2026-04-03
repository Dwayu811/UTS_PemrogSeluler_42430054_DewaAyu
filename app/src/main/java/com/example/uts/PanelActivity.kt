package com.example.uts

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {

    lateinit var tvDosen: TextView
    lateinit var etNilai: EditText
    lateinit var btnGenerate: Button
    lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        tvDosen = findViewById(R.id.tvDosen)
        etNilai = findViewById(R.id.etNilai)
        btnGenerate = findViewById(R.id.btnGenerate)
        tvHasil = findViewById(R.id.tvHasil)

        val namaDosen = intent.getStringExtra("NAMA_DOSEN")
        tvDosen.text = "Dosen: $namaDosen"

        btnGenerate.setOnClickListener {
            val nilai = etNilai.text.toString().toInt()

            var status: String

            // 🔹 IF ELSE
            if (nilai >= 75) {
                status = "LULUS"
            } else {
                status = "TIDAK LULUS"
            }

            var hasil = "Status: $status\n\nDaftar Nilai:\n"

            // 🔹 LOOP
            for (i in 1..5) {
                hasil += "Mahasiswa $i : $nilai\n"
            }

            tvHasil.text = hasil
        }
    }
}