package com.example.utsdragan

import android.content.Intent
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

/**
 * Kelas [MainActivity] adalah kelas utama yang mewakili tata letak utama aplikasi.
 * Aktivitas ini menangani tampilan awal aplikasi dan tombol Register dan Login.
 */
class MainActivity : AppCompatActivity() {
    /**
     * Metode [onCreate] dipanggil saat aktivitas dibuat.
     * @param savedInstanceState Menyimpan status aktivitas jika ada perubahan konfigurasi.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan tata letak (layout) ke aktivitas ini
        setContentView(R.layout.activity_main)

        // Mendapatkan referensi ke tombol Register dan Login dari tata letak
        val btnRegister = findViewById<AppCompatButton>(R.id.btn_register)
        val btnLogin = findViewById<AppCompatButton>(R.id.btn_login)

        // Menambahkan fungsi klik pada tombol Register
        btnRegister.setOnClickListener {
            // Tindakan ketika tombol Register diklik
            // Memulai aktivitas baru (RegisterActivity) saat tombol Register diklik
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        // Menambahkan fungsi klik pada tombol Login
        btnLogin.setOnClickListener {
            // Tindakan ketika tombol Login diklik
            // Memulai aktivitas baru (LoginActivity) saat tombol Login diklik
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}
