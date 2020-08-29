package com.appacoustic.android.spldistance.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appacoustic.android.spldistance.domain.CalculateAttenuation

class MainViewModel(
    private val calculateAttenuation: CalculateAttenuation
) : ViewModel() {

    private var _attenuation = MutableLiveData<Float>()
    val attenuation: LiveData<Float> = _attenuation

    private var _distance = MutableLiveData<Float>()
    val distance: LiveData<Float> = _distance

    init {
//        _attenuation.value = 0f
//        _distance.value = 0f
    }

    fun handleDistanceChanged(input: CharSequence?) {
        val attenuation = calculateAttenuation(input)
        _attenuation.value = attenuation
    }
}
