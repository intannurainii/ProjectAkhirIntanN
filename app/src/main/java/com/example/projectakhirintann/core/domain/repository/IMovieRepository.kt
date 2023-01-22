package com.example.projectakhirintann.core.domain.repository

import com.example.projectakhirintann.core.data.remote.Resource
import com.example.projectakhirintann.core.domain.model.Movie
import com.example.projectakhirintann.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getMovies(): Flow<Resource<List<Movie>>>
    fun getTvShow(): Flow<Resource<List<TvShow>>>
}