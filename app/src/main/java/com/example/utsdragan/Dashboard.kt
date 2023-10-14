package com.example.utsdragan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class Dashboard : AppCompatActivity() {
    private var selectedDate: String? = null // Variabel untuk menyimpan tanggal terpilih

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Inisialisasi elemen-elemen tampilan
        val tanggalTextView = findViewById<TextView>(R.id.txttanggal)
        val asalTextView = findViewById<TextView>(R.id.txtStasiunAsal)
        val tujuanTextView = findViewById<TextView>(R.id.txtStasiunTujuan)
        val namaKeretaTextView = findViewById<TextView>(R.id.txtNamaKereta)
        val paketTextView = findViewById<TextView>(R.id.txtPaket)

        // Mengambil data dari Intent
        val intent = intent
        if (intent != null) {
            // Mengambil data yang dikirim melalui Intent
            selectedDate = intent.getStringExtra("tanggal")
            val asal = intent.getStringExtra("asal")
            val tujuan = intent.getStringExtra("tujuan")
            val paket = intent.getStringExtra("paket")
            val Nama = intent.getStringExtra("Nama")

            // Menetapkan data ke elemen tampilan
            tanggalTextView.text = selectedDate
            asalTextView.text = asal
            tujuanTextView.text = tujuan
            namaKeretaTextView.text = Nama
            paketTextView.text = paket
        }

        // Menginisialisasi dan menangani perubahan tanggal pada CalendarView
        val calendarView = findViewById<CalendarView>(R.id.calenderView)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Memeriksa apakah tanggal terpilih cocok dengan tanggal yang diklik pada kalendar
            if (selectedDate == "$year-${month + 1}-$dayOfMonth") {
                Toast.makeText(
                    this,
                    "Ada Rencana Perjalanan Untuk $year-${month + 1}-$dayOfMonth",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Tidak Ada Perjalanan Untuk $year-${month + 1}-$dayOfMonth",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Menginisialisasi dan menangani klik tombol logout
        val logoutButton = findViewById<ImageView>(R.id.logoutButton)
        logoutButton.setOnClickListener{
            // Kode untuk melakukan logout
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        // Menginisialisasi dan menangani klik tombol tambah untuk pergi ke halaman input
        val addButton = findViewById<AppCompatButton>(R.id.addButton)
        addButton.setOnClickListener {
            // Membuka layar Input_rencana ketika tombol tambah diklik
            val intent = Intent(this, Input_rencana::class.java)
            startActivity(intent)
        }
    }
}
