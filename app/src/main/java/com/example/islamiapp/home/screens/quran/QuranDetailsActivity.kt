package com.example.islamiapp.home.screens.quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islamiapp.Constants
import com.example.islamiapp.databinding.ActivityDetailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class QuranDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val quran = intent.getSerializableExtra(Constants.QURAN) as Quran
        binding.contentTitleTv.text = Constants.SURA + quran.suraName
        val fileName = intent.getStringExtra(Constants.FILE_NAME)
        readFile(fileName)
        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    fun readFile(fileName: String?) {
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(assets.open(fileName.toString())))
            val fileLinesList: List<String> = reader.readLines()
            val fileContent = fileLinesList.joinToString(separator = " ") { line ->
                return@joinToString line + " {${fileLinesList.indexOf(line) + 1}}"
            }
            binding.contentTv.text = fileContent
            reader.close()
        } catch (e: IOException) {
            Log.e("QuranDetailsActivity/readFile", e.toString())
        }
    }
}