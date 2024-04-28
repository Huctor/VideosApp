package com.example.videosapp.navigation

/**
 * Created by Hu AN on 28/04/2024
 */

// Route is used to navigate view
sealed class Route(
    var route: String
){
    object DetailsView : Route(route = "detailsView")

    object AppStartNavigation : Route(route = "appStartNavigation")

    object VideosNavigation : Route(route = "videosNavigation")

    object VideosNavigatorScreen : Route(route = "videosNavigator")
}