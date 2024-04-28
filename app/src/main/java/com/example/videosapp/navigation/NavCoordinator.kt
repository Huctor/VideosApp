package com.example.videosapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.videosapp.model.Video
import com.example.videosapp.view.DetailsView
import com.example.videosapp.view.HomeView
import com.example.videosapp.view.PlayVideoView
import com.example.videosapp.viewModel.HomeViewModel

/**
 * Created by Hu AN on 28/04/2024
 */

// navigate different views
@Composable
fun NavCoordinator(
    startDestination:String
){
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.VideosNavigation.route,
            startDestination = Route.VideosNavigatorScreen.route
        ) {

            // navigate to HomeView
            composable(route = Route.VideosNavigatorScreen.route){
                val viewModel: HomeViewModel = hiltViewModel()
                val videos = viewModel.videos.collectAsLazyPagingItems()
                HomeView(videos, navigateToDetails = {
                    navigateToDetails(
                        navController = navController
                    )
                })
            }

            // navigate to DetailsView
            composable(route = Route.DetailsView.route) {
                DetailsView(
                    navigateUp = { navController.navigateUp() })
            }
        }
    }
}

// set DetailsView
private fun navigateToDetails(navController: NavController){
    navController.navigate(
        route = Route.DetailsView.route
    )
}