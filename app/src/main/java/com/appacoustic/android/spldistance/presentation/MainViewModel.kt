package com.appacoustic.android.spldistance.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appacoustic.android.spldistance.domain.CalculateAttenuation

class MainViewModel(
    private val calculateAttenuation: CalculateAttenuation
) : ViewModel() {

    private var _attenuation = MutableLiveData<Float?>()
    val attenuation: LiveData<Float?> = _attenuation

    init {
        _attenuation.value = null
    }

    fun handleDistanceChanged(input: CharSequence?) {
        calculateAttenuation(input)
            .fold({
                _attenuation.value = null
            }, { attenuation ->
                _attenuation.value = attenuation
            })
    }
}
