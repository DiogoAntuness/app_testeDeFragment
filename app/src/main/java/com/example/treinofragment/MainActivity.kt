package com.example.treinofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.treinofragment.databinding.ActivityMainBinding
import com.example.treinofragment.fragments.PrimeFragment
import com.example.treinofragment.fragments.SegundFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace( R.id.fragmentCV, PrimeFragment() )
                .commit()
        }

        binding.btn2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentCV, SegundFragment())
                .commit()

        }
        binding.btnThread.setOnClickListener { MinhaThread().start() }

    }

    inner class MinhaThread : Thread() {
        override fun run() {
            super.run()

            repeat(15){indece ->
                Log.i("info_thread", "Executando: $indece T: ${currentThread().name}")
                runOnUiThread{
                    Toast.makeText(applicationContext, "Threaddddd", Toast.LENGTH_LONG).show()
                    Log.i("info_thread", "Executando_no_main: $indece T: ${currentThread().name}")
                    binding.btnThread.text = "Executando"
                }
                sleep(1000) // 1000ms == 1s

            }
        }
    }
}