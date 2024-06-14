import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    val weather by viewModel.weather.collectAsState(initial = null)
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    var city by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Enter City") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.fetchWeather(city, "your_api_key") }) {
            Text("Get Weather")
        }
        Spacer(modifier = Modifier.height(16.dp))
        when {
            isLoading -> CircularProgressIndicator()
            error != null -> Text("Error: $error")
            weather != null -> WeatherInfo(weather!!)
        }
    }
}

@Composable
fun WeatherInfo(weather: WeatherResponse) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Temperature: ${weather.main.temp}°C")
        Text("Humidity: ${weather.main.humidity}%")
        Text("Pressure: ${weather.main.pressure} hPa")
        weather.weather.forEach { weatherItem ->
            Text(weatherItem.description)
        }
    }
}
