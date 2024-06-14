package com.example.meteocompose.data.repository

import WeatherApi
import WeatherResponse

class WeatherRepository(private val api: WeatherApi) {
    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        return api.getWeather(city, apiKey)
    }
}
