package com.example.islamiapp.home.screens.hadeth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamiapp.Constants
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityDetailsBinding

class HadeethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val hadeeth = intent.getSerializableExtra(Constants.HADEETH) as Hadeeth
        binding.contentTitleTv.text = hadeeth.hadeethTitle
        binding.contentTv.text = hadeeth.hadeethContent
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}