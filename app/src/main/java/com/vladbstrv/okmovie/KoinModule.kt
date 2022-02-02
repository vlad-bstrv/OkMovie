package com.vladbstrv.okmovie

import com.vladbstrv.okmovie.model.repository.Repository
import com.vladbstrv.okmovie.model.repository.RepositoryImpl
import com.vladbstrv.okmovie.screens.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl()}

//    viewModel {
//        DetailViewModel(get())
//    }
}