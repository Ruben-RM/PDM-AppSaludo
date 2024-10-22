package com.example.saludapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnHello:AppCompatButton = findViewById(R.id.btnHello)

        /* PRIMER LISTENER
        btnHello.setOnClickListener()
        {
            // Log.i("Test", "Boton Pulsado")

            val etName:AppCompatEditText = findViewById(R.id.etName)

            val name = etName.text.toString()

            // Toast.makeText(this, "Hola $name!", Toast.LENGTH_LONG).show()
            if(name.isNotEmpty())
            {
                Snackbar.make(btnHello, "HOla $name!", Snackbar.LENGTH_SHORT)
                    .setAnchorView(btnHello)
                    .setAction("CLOSE"){finishAffinity()}
                    .show()
            }

            etName.setText(null)
        }
        */

        btnHello.setOnClickListener()
        {
            val etName:AppCompatEditText = findViewById(R.id.etName)

            val name = etName.text.toString()

            val intentGA = Intent(this, GreetingActivity::class.java)
            intentGA.putExtra("EXTRA_NAME", name)

            startActivity(intentGA)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}