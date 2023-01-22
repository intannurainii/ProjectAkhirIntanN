package com.example.projectakhirintann.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var name: String,
    @SerializedName("overview")
    var desc: String?,
    @SerializedName("poster_path")
    var poster: String?,
    @SerializedName("backdrop_path")
    var imgPreview: String?,
    @SerializedName("release_date")
    var releaseDate: String?
)
