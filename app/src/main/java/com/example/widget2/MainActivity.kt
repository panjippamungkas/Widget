package com.example.widget2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.widget2.databinding.ActivityMainBinding

//Buat Variabel Binding Baru
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisialisasi binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //memanggil layout menggunakan binding.root
        setContentView(binding.root)

        val getData = intent.getParcelableExtra<ModelLogin>("data")
        binding.txtUserName.text = getData?.username.toString()
        binding.txtPassword.text = getData?.password.toString()

        //Explicit Intent
        binding.btnIntentWidget.setOnClickListener {
            val intent = Intent(this, Widget2::class.java)
            startActivity(intent)
        }

        binding.btnIntentExplicit.setOnClickListener {
            val intent = Intent(this,ImplicitIntent::class.java )
            startActivity(intent)
        }

    }
}