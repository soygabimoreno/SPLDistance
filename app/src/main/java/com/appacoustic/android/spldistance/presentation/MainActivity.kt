package com.appacoustic.android.spldistance.presentation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import com.appacoustic.android.spldistance.databinding.ActivityMainBinding
import com.appacoustic.android.spldistance.framework.setOnTextChangedListener
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ScopeActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel(binding)
        initEditText(binding)
    }

    private fun initViewModel(binding: ActivityMainBinding) {
        viewModel.attenuation.observe(
            this,
            { attenuation ->
                binding.tvAttenuationResult.text = attenuation?.toString() ?: "?"
            })
    }

    private fun initEditText(binding: ActivityMainBinding) {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                binding.etDistance.requestFocus()
                val imr = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imr.showSoftInput(
                    binding.etDistance,
                    InputMethodManager.SHOW_IMPLICIT
                )
            },
            500
        )

        binding.etDistance.setOnTextChangedListener { input ->
            viewModel.handleDistanceChanged(input)
        }
    }
}
