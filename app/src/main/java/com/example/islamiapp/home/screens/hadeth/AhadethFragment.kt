package com.example.islamiapp.home.screens.hadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.Constants
import com.example.islamiapp.databinding.FragmentAhadethBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class AhadethFragment : Fragment() {
    lateinit var binding: FragmentAhadethBinding
    lateinit var ahadethArrayList: ArrayList<Hadeeth>
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
        ahadethArrayList = ArrayList()
        readAhadeethFile()
        hadeethAdapter = HadeethAdapter(ahadethArrayList)
        hadeethAdapter.onHadeethClick = object : HadeethAdapter.OnHadeethClick {
            override fun onHadeethClick(hadeeth: Hadeeth, position: Int) {
                val intent = Intent(activity, HadeethDetailsActivity::class.java)
                intent.putExtra(Constants.HADEETH, hadeeth)
                startActivity(intent)
            }

        }
        binding.ahadethRv.adapter = hadeethAdapter
    }

    fun readAhadeethFile() {
        var reader: BufferedReader? = null
        try {
            reader =
                BufferedReader(InputStreamReader(requireActivity().assets.open("ahadeeth.txt")))
            val contentLines = reader.readText()
            val ahadeethList: List<String> = contentLines.split("#")
            for (hadeeth: String in ahadeethList) {
                val hadeethLines: MutableList<String> = hadeeth.trim().split("\n").toMutableList()
                val hadeethTitle = hadeethLines[0]
//                Log.e("hadeeth",hadeeth.split(hadeethTitle).toString())
                hadeethLines.removeAt(0)
                ahadethArrayList.add(
                    Hadeeth(
                        hadeethTitle,
                        hadeethLines.joinToString(separator = "") {
                            return@joinToString it
                        })
                )
            }
            reader.close()
        } catch (e: IOException) {
            Log.e("AhadethFragment/readAhadeethFile", e.toString())
        }
    }
}