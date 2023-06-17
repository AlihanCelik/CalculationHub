package com.example.calculatorapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class VpAdapter(fa:FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fa,lifecycle) {
    private val fragmentList = mutableListOf<Fragment>()
    private val fragmenttitle = mutableListOf<String>()


    fun addFragment(fragment: Fragment,title:String){
        fragmentList.add(fragment)
        fragmenttitle.add(title)
    }

    override fun getItemCount(): Int =fragmentList.size



    override fun createFragment(position: Int): Fragment =fragmentList[position]

    fun getFragmentTitle(position: Int): String = fragmenttitle[position]


}