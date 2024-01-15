package com.example.islamiapp.home.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.databinding.FragmentAhadethBinding
import com.example.islamiapp.home.Adapter

class AhadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    lateinit var AhadethArrayList: ArrayList<String>
    lateinit var AhadethAdapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAhadethBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AhadethArrayList = ArrayList()
        fillList()
        AhadethAdapter = Adapter(AhadethArrayList)
        binding.ahadethRv.adapter = AhadethAdapter
    }

    fun fillList(){
        for (item in 1..11){
            AhadethArrayList.add(" الحديث رقم " + item)
        }
    }
}