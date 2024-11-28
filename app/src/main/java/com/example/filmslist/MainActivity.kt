package com.example.filmslist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.filmslist.ui.theme.FilmsListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmsListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FilmListScreen()
                }
            }
        }
    }
}

// Step 1: Data class to hold fruit details
data class FilmModel(val name: String, val director: String, val image: Int)

// Step 2: Custom row to display each fruit
@Composable
fun ListRow(model: FilmModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(Color(0xFF063041)) // Using hexadecimal color
    ) {
        Column () {
            Image(
                painter = painterResource(id = model.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)
            )
        }
        Column () {
            Text(
                text = model.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text = model.director,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }
}

// Step 3 and 4: Fruit list initialization
val fruitsList = mutableListOf(
    FilmModel("El señor de los anillos","Peter Jackson", R.drawable.lord),
    FilmModel("Seven Samurai","Akira Kurosawa", R.drawable.sevensamurai),
    FilmModel("Ciudadano Kane","Orson Welles", R.drawable.kane),
    FilmModel("The Dark Cristal","David Odell and Frank Oz", R.drawable.dark),
    FilmModel("Willow","Ron Howard", R.drawable.willow),
    FilmModel("El mago de Oz","Victor Fleming", R.drawable.wizard),
    FilmModel("Dragonheart","Rob Cohen", R.drawable.dragon),
    FilmModel("Goodfellas","Martin Scorsese", R.drawable.god),
    FilmModel("Salvando al soldado Ryan","Steven Spielberg", R.drawable.ryan),
    FilmModel("El silencio de los corderos","Jonathan Demme", R.drawable.lambs),
    FilmModel("El Padrino","Francis Ford Coppola", R.drawable.padrino),
    FilmModel("Excalibur","John Boorman", R.drawable.excalibur),

)

// Step 5: LazyColumn to display the list
@Composable
fun FilmListScreen() {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmsListTheme {
        FilmListScreen()
    }
}
