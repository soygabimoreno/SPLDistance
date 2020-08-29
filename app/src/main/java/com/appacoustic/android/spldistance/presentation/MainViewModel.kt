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

    fun handleDistanceChanged(input: CharSequence?) {
        calculateAttenuation(input)
            .fold({
                // Do nothing
            }, { attenuation ->
                _attenuation.value = attenuation
            })
    }
}
