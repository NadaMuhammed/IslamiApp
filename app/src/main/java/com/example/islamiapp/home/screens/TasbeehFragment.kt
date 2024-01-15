package com.example.islamiapp.home.screens

import android.opengl.Matrix
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.islamiapp.Constants
import com.example.islamiapp.R
import com.example.islamiapp.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    var tasbeehCnt = 0
    var tasbeehCompleted = 1
    var angleCnt = 10f
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
        binding.tasbeehBtn.setOnClickListener {
            addCounter()
        }
    }

    fun addCounter() {
        tasbeehCnt++
        binding.tsbehatCountTv.text = tasbeehCnt.toString()
        rotateSebha(angleCnt)
        if (tasbeehCnt % 30 == 0)
            changeTasbeeh()
    }

    fun rotateSebha(angle: Float) {
        binding.sebhaImv.animate().rotation(angle)
        angleCnt+=10
    }

    private fun changeTasbeeh() {
        when (tasbeehCompleted) {
            1 -> {
                tasbeehCompleted++
                binding.tasbeehBtn.text = Constants.ALHAMDULELLAH
            }

            2 -> {
                tasbeehCompleted++
                binding.tasbeehBtn.text = Constants.LA_ELLAH_ELA_ALLAH
            }

            3 -> {
                tasbeehCompleted++
                binding.tasbeehBtn.text = Constants.ALLAH_AKBAR
            }

            4 -> {
                tasbeehCompleted = 1
                binding.tasbeehBtn.text = Constants.SOBHAN_ALLAH
            }
        }
    }


}