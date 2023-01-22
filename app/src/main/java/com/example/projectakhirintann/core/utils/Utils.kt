package com.example.projectakhirintann.core.utils

import com.example.projectakhirintann.core.data.remote.response.MovieResponse
import com.example.projectakhirintann.core.data.remote.response.TvShowResponse
import com.example.projectakhirintann.core.domain.model.Movie
import com.example.projectakhirintann.core.domain.model.TvShow

fun mapMovieResponseToDomain(input: MovieResponse) =
    Movie(
        input.id,
        input.name,
        input.desc,
        input.poster,
        input.imgPreview,
        input.releaseDate
    )

fun mapTvShowResponseToDomain(input: TvShowResponse) =
    TvShow(
        input.id,
        input.name,
        input.desc,
        input.poster,
        input.imgPreview,
        input.releaseDate
    )
