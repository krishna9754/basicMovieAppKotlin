package com.example.movieapp.Navigation

import java.lang.IllegalArgumentException



enum class MovieScreen{
    HomeScreen,
    DetailScreen;
    companion object {
        fun fromRoute(route: String?): MovieScreen
        = when(route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailScreen.name -> DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
        }
    }
}