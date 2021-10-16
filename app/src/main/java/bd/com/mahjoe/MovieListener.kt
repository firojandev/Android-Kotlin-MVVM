package bd.com.mahjoe

import bd.com.mahjoe.model.Movie

interface MovieListener {
    fun onMovieItemClick(movie:Movie)
}