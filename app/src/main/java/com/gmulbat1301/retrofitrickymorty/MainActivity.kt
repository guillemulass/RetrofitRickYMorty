package com.gmulbat1301.retrofitrickymorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.gmulbat1301.retrofitrickymorty.data.RetrofitServiceFactory
import com.gmulbat1301.retrofitrickymorty.ui.theme.RetrofitRickYMortyTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creo un servicio de Retrofit
        val service = RetrofitServiceFactory.makeRetrofitService()

        // Lanzo el servicio
        lifecycleScope.launch {
            val character = service.characterInfo(3)
            println(character) // Creo este print para parar la depuracion aqui
        }

        setContent {
            RetrofitRickYMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitRickYMortyTheme {
        Greeting("Android")
    }
}