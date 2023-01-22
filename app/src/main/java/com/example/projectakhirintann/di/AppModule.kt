package com.example.projectakhirintann.di

import com.example.projectakhirintann.core.domain.usecase.movie.MovieInteractor
import com.example.projectakhirintann.core.domain.usecase.movie.MovieUseCase
import com.example.projectakhirintann.ui.movie.MovieViewModel
import com.example.projectakhirintann.ui.tvshow.TvShowViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvShowViewModel(get()) }
}