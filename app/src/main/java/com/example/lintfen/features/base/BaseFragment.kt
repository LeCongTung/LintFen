package com.example.lintfen.features.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {

    abstract fun getLayout(): Int
    abstract fun initView(view: View)
    abstract fun initData()
    abstract fun initEventListener()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)
        initView(view)
        initData()
        initEventListener()
        return view
    }
}