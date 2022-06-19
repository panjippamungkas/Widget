package com.example.widget2

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.widget2.databinding.ActivityWidget2Binding
import com.google.android.material.snackbar.Snackbar

//Buat Variabel Binding Baru
private lateinit var binding: ActivityWidget2Binding
class Widget2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inisialisasi binding
        binding = ActivityWidget2Binding.inflate(layoutInflater)
        //memanggil layout menggunakan binding.root
        setContentView(binding.root)

        //button Toast
       binding.btnToast.setOnClickListener {
           Toast.makeText(this,"ini adalah Toast", Toast.LENGTH_SHORT).show()
       }
        //button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah Snackbar", Snackbar.LENGTH_SHORT).show()
        }

        //button Alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("ini adalah Alert")

                setPositiveButton("OK"){dialog,_ ->
                 Toast.makeText(applicationContext, "Anda Click OK", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
                }

                setNegativeButton("Back"){dialog,_ ->
                    Toast.makeText(applicationContext, "Anda Click Back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }.show()
        }

        //button Custom Dialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog2)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda Click Cancel",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda Click Continue",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()

        }

        }
    }
