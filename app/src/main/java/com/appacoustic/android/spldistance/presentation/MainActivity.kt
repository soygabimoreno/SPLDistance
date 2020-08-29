package com.appacoustic.android.spldistance.presentation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.appacoustic.android.spldistance.R
import com.appacoustic.android.spldistance.framework.setOnTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.androidx.scope.lifecycleScope as koinScope

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by koinScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initEditText()
    }

    private fun initViewModel() {
        viewModel.attenuation.observe(this, { attenuation ->
            tvAttenuationResult.text = attenuation.toString()
        })
    }

    private fun initEditText() {
        Handler(Looper.getMainLooper()).postDelayed({
            etDistance.requestFocus()
            val imr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imr.showSoftInput(etDistance, InputMethodManager.SHOW_IMPLICIT)
        }, 500)

        etDistance.setOnTextChangedListener { input ->
            viewModel.handleDistanceChanged(input)
        }
    }
}
