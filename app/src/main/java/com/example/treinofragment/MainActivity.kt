package com.example.treinofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                .replace( R.id.fragment_CV, PrimeFragment() )
                .commit()
        }

        binding.btn2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_CV, SegundFragment())
                .commit()

        }
    }
}