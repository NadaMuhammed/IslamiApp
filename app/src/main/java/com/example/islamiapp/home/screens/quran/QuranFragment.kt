package com.example.islamiapp.home.screens.quran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.Constants
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.home.screens.hadeth.HadeethAdapter

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
    }

    fun fillLists() {
        for (item in 1..11) {
            quranArrayList.add(Quran(Constants.SURAT_AL_BAQARA, 285))
        }
    }
}