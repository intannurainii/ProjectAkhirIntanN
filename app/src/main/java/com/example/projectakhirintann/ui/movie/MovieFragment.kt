package com.example.projectakhirintann.ui.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projectakhirintann.core.data.remote.Resource
import com.example.projectakhirintann.core.domain.model.Movie
import com.example.projectakhirintann.databinding.FragmentMovieBinding
import com.example.projectakhirintann.ui.detail.DetailActivity
import com.example.projectakhirintann.utils.showToast
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private lateinit var binding: FragmentMovieBinding

    private lateinit var adapter: MovieAdapter

    private val viewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        if (_binding == null) {
            _binding = FragmentMovieBinding.inflate(inflater, container, false)
            binding = _binding as FragmentMovieBinding
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = MovieAdapter().apply {
            onClick { data ->
                Intent(activity, DetailActivity::class.java).also { intent ->
                    intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.data[1])
                    intent.putExtra(DetailActivity.EXTRA_DATA, data)
                    startActivity(intent)
                }
            }
        }

        getMovies()
    }

    private fun getMovies() {

        viewModel.getMovies().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> showLoading(true)
                is Resource.Success -> {
                    if (it.data != null) {
                        adapter.movies = it as MutableList<Movie>
                        binding.apply {
                            rvMovie.setHasFixedSize(true)
                            rvMovie.adapter = adapter

                        }

                        showLoading(false)
                    }
                }
                is Resource.Error -> {
                    showLoading(false)
                    activity?.showToast(it.message.toString())
                }
            }
        }
    }



            private fun showLoading(state: Boolean) {
                binding.apply {
                    if (state) {
                        progressBar.visibility = View.VISIBLE
                        rvMovie.visibility = View.GONE
                    } else {
                        progressBar.visibility = View.GONE
                        rvMovie.visibility = View.VISIBLE
                    }
                }
            }

        }

