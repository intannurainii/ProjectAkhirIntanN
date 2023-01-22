package com.example.projectakhirintann.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    var id: Int,
    var name: String,
    var desc: String?,
    var poster: String?,
    var imgPreview: String?,
    var releaseDate: String?
): Parcelable
