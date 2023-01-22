package com.example.projectakhirintann.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.projectakhirintann.core.domain.model.Movie


class DivMovieCallback(private val oldItem: MutableList<Movie>, private val newItem: MutableList<Movie>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItem.size

    override fun getNewListSize(): Int = newItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldItem[oldItemPosition].id == newItem[newItemPosition].id
}