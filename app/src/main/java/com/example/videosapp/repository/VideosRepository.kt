package com.example.videosapp.repository

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.example.videosapp.model.Video

/**
 * Created by Hu AN on 28/04/2024
 */

// video repository interface
interface VideosRepository {

    // get videos
    fun getVideos(sources: List<String>): Flow<PagingData<Video>>
}