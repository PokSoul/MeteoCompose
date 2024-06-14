package com.example.meteocompose.data.network

import WeatherApi
import com.example.meteocompose.data.repository.WeatherRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }

    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepository(api)
    }
}
