package com.example.islamiapp.home.screens.tasbeeh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    var tasbeehCnt: Int = 0
    var angleCnt = 10f
    var azkarList = mutableListOf<String>()
    var currentDhikrIndex = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTasbeehBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkar_list).toMutableList()
        tasbeehCnt = 0
        angleCnt = 10f
        binding.tasbeehBtn.setOnClickListener {
            addCounter()
            rotateSebha(angleCnt)
        }
    }

    fun addCounter() {
        if (tasbeehCnt == 30) {
            changeTasbeeh()
            tasbeehCnt = 0
        } else {
            tasbeehCnt++
        }
        binding.tsbehatCountTv.text = tasbeehCnt.toString()

    }

    fun rotateSebha(angle: Float) {
        binding.sebhaImv.animate().rotation(angle)
        angleCnt += 10
    }

    private fun changeTasbeeh() {
        currentDhikrIndex = if (currentDhikrIndex < azkarList.size - 1) ++currentDhikrIndex else 0
        binding.tasbeehBtn.text = azkarList[currentDhikrIndex]
    }


}