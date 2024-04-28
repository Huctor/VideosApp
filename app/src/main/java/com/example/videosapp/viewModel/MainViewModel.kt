package com.example.videosapp.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videosapp.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * Created by Hu AN on 28/04/2024
 */

// main view viewmodel
@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
    val startDestination: State<String> = _startDestination

    init {
        _startDestination.value = Route.VideosNavigation.route
    }

}