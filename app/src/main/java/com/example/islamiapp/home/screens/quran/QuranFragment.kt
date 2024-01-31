package com.example.islamiapp.home.screens.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.Constants
import com.example.islamiapp.databinding.FragmentQuranBinding

class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var quranAdapter: QuranAdapter
    lateinit var quranArrayList: ArrayList<Quran>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        quranArrayList = ArrayList()
        fillLists()
        quranAdapter = QuranAdapter(quranArrayList)
        binding.suraRv.adapter = quranAdapter
        quranAdapter.onQuranClick = object : QuranAdapter.OnQuranClick {
            override fun onQuranClick(quran: Quran, index: Int) {
                val intent = Intent(activity, QuranDetailsActivity::class.java)
                intent.putExtra(Constants.QURAN, quran)
                intent.putExtra(Constants.FILE_NAME, "${index + 1}.txt")
                startActivity(intent)
            }
        }
    }

    fun fillLists() {
        for (sura in 0..<Constants.SURAHS_NAMES.size) {
            quranArrayList.add(
                Quran(
                    Constants.SURAHS_NAMES.get(sura),
                    Constants.AYAT_NUMBERS.get(sura)
                )
            )
        }

    }
}