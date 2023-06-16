package com.example.lintfen.features.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class Adapter(
    fm: FragmentManager
): FragmentPagerAdapter(fm)
{
    override fun getCount(): Int {
        return 3;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return FirstFragment()
            }
            1 -> {
                return SecondFragment()
            }
            else -> {
                return ThirdFragment()
            }
        }
    }

}