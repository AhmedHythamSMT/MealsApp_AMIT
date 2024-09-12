package com.example.mealsapp.ui

sealed class Screen(val route : String) {

    object MealsScreen : Screen("MealsScreen")
    object MealsDetailsScreen : Screen("MealsDetailsScreen")
}