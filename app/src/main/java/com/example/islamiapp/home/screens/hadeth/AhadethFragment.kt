package com.example.islamiapp.home.screens.hadeth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.Constants
import com.example.islamiapp.databinding.FragmentAhadethBinding

class AhadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    lateinit var AhadethArrayList: ArrayList<String>
    lateinit var hadeethAdapter: HadeethAdapter
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
        hadeethAdapter = HadeethAdapter(AhadethArrayList)
        binding.ahadethRv.adapter = hadeethAdapter
    }

    fun fillList(){
        for (item in 1..11){
            AhadethArrayList.add(Constants.HADEETH_NUMBER + item)
        }
    }
}