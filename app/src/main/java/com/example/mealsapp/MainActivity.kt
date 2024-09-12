package com.example.mealsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mealsapp.ui.Screen
import com.example.mealsapp.ui.screens.meals.MealsScreen
import com.example.mealsapp.ui.screens.mealsdetails.MealsDetailsScreen
import com.example.mealsapp.ui.theme.MealsAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealsAppTheme {
                Box(modifier = Modifier.fillMaxWidth()) {
                    MyTextView("Meals App")
                }
                Box(modifier = Modifier.fillMaxWidth().padding(5.dp,50.dp)) {
                    MealsApp()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMyTextView() {
        MyTextView(String.toString(), Modifier)
    }

    @Composable
    fun MyTextView(text: String, modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter // Aligns the content to the top-left
        ) {
            Text(
                text = text,
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp, 10.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }


    @Composable
    fun MealsApp() {
        val navHostController = rememberNavController()

        val innerPadding = 5.dp
        NavHost(
            navController = navHostController, startDestination = "MealsScreen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.MealsScreen.route) { MealsScreen(navHostController) }
            composable(Screen.MealsDetailsScreen.route) { MealsDetailsScreen(navHostController) }
        }
    }
}
