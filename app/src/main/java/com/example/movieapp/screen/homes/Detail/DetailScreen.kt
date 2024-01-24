package com.example.movieapp.screen.homes.Detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.model.getData
import com.example.movieapp.model.movieData
import com.example.movieapp.widgets.MovieRow
import kotlin.math.ceil

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen( paddingValue: PaddingValues,
    navController: NavHostController,
    movieId: String?,) {
    val newMovieList = getData().filter { movieData ->
        movieData.id == movieId;
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = { Text(text = "Movie", textAlign = TextAlign.Center) },
                navigationIcon = {
                    Row {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Arrow Back",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            )

        }
    ) {paddingValues ->
        MovieDetailsScreenWidgets(paddingValues, newMovieList)
    }
}
@Composable
fun MovieDetailsScreenWidgets(paddingValues: PaddingValues, newMovieList: List<movieData> ){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(top = 100.dp)) {
        Image(painter = rememberAsyncImagePainter(model = newMovieList[0].image), contentDescription = "Image")
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(all = 10.dp)) {
            Text(text = "Movie:- ${newMovieList[0].title}")
            Text(text ="Description:- ${newMovieList[0].description}", modifier = Modifier.padding(top = 8.dp))
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text(text ="Rating:- ${newMovieList[0].rating}", modifier = Modifier.padding(end = 10.dp))
                Text(text ="Released:- ${newMovieList[0].year}", modifier = Modifier.padding(start = 10 .dp))
            }

        }
    }
}






