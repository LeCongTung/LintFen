package com.example.lintfen.features.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

abstract class BaseActivity: AppCompatActivity() {

    abstract fun getLayout(): ConstraintLayout
    abstract fun initView()
    abstract fun initData()
    abstract fun initEventListener()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initData()
        initView()
        initEventListener()
    }

//    Base functions

}