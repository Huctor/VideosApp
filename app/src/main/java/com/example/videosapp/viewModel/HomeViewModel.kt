package com.example.videosapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.videosapp.model.VideosUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Hu AN on 28/04/2024
 */

// home view viewmodel
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val videosUseCases: VideosUseCases
): ViewModel() {

    val videos = videosUseCases.getVideos(
        sources = listOf("")
    ).cachedIn(viewModelScope)

}