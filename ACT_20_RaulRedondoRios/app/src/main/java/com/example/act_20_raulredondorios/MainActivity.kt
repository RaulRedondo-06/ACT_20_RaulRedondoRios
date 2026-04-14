package com.example.act_20_raulredondorios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textEstat = findViewById<TextView>(R.id.textEstat)
        val botoDescarrega = findViewById<Button>(R.id.botoDescarrega)

        botoDescarrega.setOnClickListener {

            textEstat.text = "Descarregant..."
            botoDescarrega.isEnabled = false

            CoroutineScope(Dispatchers.IO).launch {

                val temps = Random.nextLong(2000, 5000)
                delay(temps)

                runOnUiThread {
                    textEstat.text = "Descarregat correctament!"
                    botoDescarrega.isEnabled = true
                }
            }
        }
    }
}