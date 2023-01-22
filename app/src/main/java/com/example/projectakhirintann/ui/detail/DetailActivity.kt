package com.example.projectakhirintann.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectakhirintann.core.data.remote.response.MovieResponse
import com.example.projectakhirintann.core.data.remote.response.TvShowResponse
import com.example.projectakhirintann.databinding.ActivityDetailBinding
import com.example.projectakhirintann.utils.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataIntent()
    }

    private fun getDataIntent() {
        val type = intent?.extras?.getString(EXTRA_TYPE)

        if (type == data[0]){
            getDetailMovie(data as MovieResponse)
        }else{


        }
    }

    private fun getDetailTvShow(data: TvShowResponse) {
        binding.apply {
            imgDetailPoster.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W185${data.imgPreview}")
            imgDetailHightlight.loadImageTvShow("$BASE_URL_API_IMAGE$POSTER_SIZE_W780${data.poster}")
            tvTitle.text = data.name
            tvDesc.text = if (data.desc.isNullOrEmpty()) "No Description" else data.desc
            tvReleaseDate.text = data.releaseDate
        }
    }

    private fun getDetailMovie(data: MovieResponse) {
        binding.apply {
            imgDetailPoster.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W780${data.poster}")
            imgDetailHightlight.loadImageMovie("$BASE_URL_API_IMAGE$POSTER_SIZE_W185${data.imgPreview}")
            tvTitle.text = data.name
            tvDesc.text = data.desc
            tvReleaseDate.text = data.releaseDate
        }
    }

    companion object{
        val data = arrayOf("movie", "tv show")
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "type"
    }
}