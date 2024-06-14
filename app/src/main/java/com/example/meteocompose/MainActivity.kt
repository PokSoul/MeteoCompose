package com.example.meteocompose

import WeatherScreen
import WeatherViewModel
import WeatherViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.meteocompose.data.network.NetworkModule


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val api = NetworkModule.provideWeatherApi(NetworkModule.provideRetrofit())
        val repository = NetworkModule.provideWeatherRepository(api)
        val viewModelFactory = WeatherViewModelFactory(repository)
        val viewModel = ViewModelProvider(this as ViewModelStoreOwner, viewModelFactory)[WeatherViewModel::class.java]

        setContent {
            WeatherScreen(viewModel = viewModel)
        }
    }
}
