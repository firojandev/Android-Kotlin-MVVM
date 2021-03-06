package bd.com.mahjoe.networking

import bd.com.mahjoe.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    //https://howtodoandroid.com/movielist.json

    @GET("898976916741308416")
    fun getAllMovies() : Call<List<Movie>>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitService == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonblob.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }

            return retrofitService!!
        }
    }

}