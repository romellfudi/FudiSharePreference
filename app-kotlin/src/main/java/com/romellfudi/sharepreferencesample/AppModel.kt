/*
 * Copyright (c) 2021. BoostTag E.I.R.L. Romell D.Z.
 * All rights reserved
 * portfolio.romellfudi.com
 */

package com.romellfudi.sharepreferencesample

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Application Koin module
 *
 * @version 1.0.a
 * @autor Romell Domínguez (@romellfudi)
 * @date 4/1/21
 */
val appModule = module {

    viewModel { FudiViewModel() }

}