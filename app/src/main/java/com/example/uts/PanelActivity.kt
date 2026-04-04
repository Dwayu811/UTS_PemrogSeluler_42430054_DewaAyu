package com.example.uts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {

    private lateinit var tvDosen: TextView
    private lateinit var etNamaMahasiswa: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvHasil: TextView
    private lateinit var nilaiInputs: List<EditText>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        tvDosen = findViewById(R.id.tvDosen)
        etNamaMahasiswa = findViewById(R.id.etNamaMahasiswa)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvHasil = findViewById(R.id.tvHasil)

        nilaiInputs = listOf(
            findViewById(R.id.etNilai1),
            findViewById(R.id.etNilai2),
            findViewById(R.id.etNilai3),
            findViewById(R.id.etNilai4),
            findViewById(R.id.etNilai5),
            findViewById(R.id.etNilai6),
            findViewById(R.id.etNilai7),
            findViewById(R.id.etNilai8)
        )

        val namaDosen = intent.getStringExtra("NAMA_DOSEN") ?: "Dosen"
        tvDosen.text = "Dosen: $namaDosen"

        btnSubmit.setOnClickListener {
            generateNilai()
        }
    }

    private fun generateNilai() {
        val namaMahasiswa = etNamaMahasiswa.text.toString().trim()

        if (namaMahasiswa.isEmpty()) {
            etNamaMahasiswa.error = "Nama tidak boleh kosong"
            return
        }

        var total = 0
        val detailHasil = StringBuilder()
        detailHasil.append("Mahasiswa: $namaMahasiswa\n\n")

        // 🔥 FOR LOOP (WAJIB MODUL 5)
        for (i in nilaiInputs.indices) {
            val nilaiStr = nilaiInputs[i].text.toString()
            val nilai = nilaiStr.toIntOrNull()

            if (nilai == null || nilai !in 0..100) {
                nilaiInputs[i].error = "Nilai 0-100"
                return
            }

            total += nilai
            detailHasil.append("Nilai ${i + 1}: $nilai\n")
        }

        val rataRata = total / nilaiInputs.size

        // 🔹 Status
        val status = if (rataRata >= 75) "Lulus" else "Tidak Lulus"

        // 🔹 Grade
        val grade = when {
            rataRata >= 80 -> "A"
            rataRata >= 75 -> "B"
            rataRata >= 60 -> "C"
            rataRata >= 45 -> "D"
            else -> "E"
        }

        detailHasil.append("\n------------------")
        detailHasil.append("\nRata-rata: $rataRata")
        detailHasil.append("\nStatus: $status")
        detailHasil.append("\nGrade: $grade")

        tvHasil.text = detailHasil.toString()
    }
}