package bd.com.mahjoe.repository

import bd.com.mahjoe.networking.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService){
    fun getAllMovies() = retrofitService.getAllMovies()
}