package bd.com.mahjoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import bd.com.mahjoe.databinding.ActivityMainBinding
import bd.com.mahjoe.networking.RetrofitService
import bd.com.mahjoe.repository.MainRepository
import bd.com.mahjoe.viewmodel.MainViewModel
import bd.com.mahjoe.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()

    val adapter = MainAdapter()

    private var movieListener: MovieListener? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(this, Observer {

        })

        viewModel.getAllMovies()

    }
}