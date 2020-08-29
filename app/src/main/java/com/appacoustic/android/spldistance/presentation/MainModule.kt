package com.appacoustic.android.spldistance.presentation

import com.appacoustic.android.spldistance.domain.CalculateAttenuation
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainModule = module {
    single { CalculateAttenuation() }
    scope(named<MainActivity>()) {
        viewModel {
            MainViewModel(
                calculateAttenuation = get()
            )
        }
    }
}
