package com.example.widget2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget2.databinding.ActivityLoginBinding


private lateinit var binding: ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val datalogin = ModelLogin(binding.textPUserName.text.toString(),binding.textPPassword.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", datalogin)
            startActivity(intent)
            finish()
        }
    }
}