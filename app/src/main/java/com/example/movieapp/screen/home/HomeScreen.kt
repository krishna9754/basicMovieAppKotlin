package com.example.movieapp.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.Navigation.MovieScreen
import com.example.movieapp.model.getData
import com.example.movieapp.model.movieData
import com.example.movieapp.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                title = {
                    Text(text = "Movie")
                }
            )
        },
    ){
       MainContain(navController = navController)
    }

}

@Composable
fun MainContain(
    navController: NavController,
    movieList: List<movieData> = getData()
){
    Column(modifier = Modifier.padding(top = 70.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreen.DetailScreen.name+"/$movie")
                    Log.d("Tag", "MainContain : $movie")
                }
            }
        }
    }
}