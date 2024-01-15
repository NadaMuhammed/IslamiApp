package com.example.islamiapp.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHomeBinding
import com.example.islamiapp.home.screens.hadeth.AhadethFragment
import com.example.islamiapp.home.screens.quran.QuranFragment
import com.example.islamiapp.home.screens.RadioFragment
import com.example.islamiapp.home.screens.TasbeehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    val radioFragment = RadioFragment()
    val tasbeehFragment = TasbeehFragment()
    val ahadethFragment = AhadethFragment()
    val quranFragment = QuranFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setCurrentFragment(radioFragment)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.radio -> setCurrentFragment(radioFragment)
                R.id.tasbeeh -> setCurrentFragment(tasbeehFragment)
                R.id.ahadeth -> setCurrentFragment(ahadethFragment)
                R.id.quran -> setCurrentFragment(quranFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment, "")
            .commit()
    }


//    override fun onSupportNavigateUp(): Boolean {
//        return super.onSupportNavigateUp() || findNavController(R.id.fragmentContainerView).navigateUp()
//    }
}