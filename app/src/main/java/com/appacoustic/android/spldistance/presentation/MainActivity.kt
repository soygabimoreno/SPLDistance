package com.appacoustic.android.spldistance.presentation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.appacoustic.android.spldistance.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEditText()
    }

    private fun initEditText() {
        Handler(Looper.getMainLooper()).postDelayed({
            etDistance.requestFocus()
            val imr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imr.showSoftInput(etDistance, InputMethodManager.SHOW_IMPLICIT)
        }, 500)
    }
}
