package com.love.geminiandroid.ui

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screens(name: String)

class TextScreen(name: String = "text") : Screens(name)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainApp() {

    val items = listOf(
        Icons.Filled.MailOutline to "Text",
        Icons.Filled.Person to "Photo",
        Icons.Filled.Send to "Chat"
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Icons
                items.forEach { item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                Icons.Rounded.MailOutline,
                                contentDescription = item.second
                            )
                        },
                        label = { Text(item.second) },
                        selected = navController.currentDestination?.route == item.second,
                        onClick = { navController.navigate(item.second) }
                    )
                }
            }
        }
    ) {
        // Navigation destinations
        NavHost(navController = navController, startDestination = "text") {
            composable(route = "text") { TextScreen() }
            composable(route = "Photo") { PhotoScreen() }
            composable(route = "Chat") { ChatScreen() }
        }
    }
}

