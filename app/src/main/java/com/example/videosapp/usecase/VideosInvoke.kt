package com.example.videosapp.usecase

import androidx.paging.PagingData
import com.example.videosapp.model.Video
import com.example.videosapp.repository.VideosRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Hu AN on 28/04/2024
 */

// invoke
class VideosInvoke(
    private val videosRepository: VideosRepository
) {
    // getVideos invoke
    operator fun invoke(sources: List<String>): Flow<PagingData<Video>> {
        return videosRepository.getVideos(sources = sources)
    }
}