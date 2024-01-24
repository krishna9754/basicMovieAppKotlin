package com.example.movieapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screen.home.HomeScreen
import com.example.movieapp.screen.homes.Detail.DetailScreen


@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreen.HomeScreen.name ){

        //MovieHome ====================================================
        composable(MovieScreen.HomeScreen.name){
          HomeScreen(navController = navController)
        }
        //MovieDetail ==================================================
        composable(MovieScreen.DetailScreen.name+"/{movieAnd-detail}",
            arguments = listOf(navArgument("movieAnd-detail"){type = NavType.StringType})
            ){
            backStackEntry ->

            DetailScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movieAnd-detail"))
        }
    }
}