package com.example.videosapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.videosapp.model.Video
import com.example.videosapp.service.VideosAPI
import com.example.videosapp.service.VideosPagingSource
import kotlinx.coroutines.flow.Flow

/**
 * Created by Hu AN on 28/04/2024
 */

// video repository implementation
class VideosRepositoryImpl(
    private val videosApi: VideosAPI,
) : VideosRepository {

    // get videos implementation
    override fun getVideos(sources: List<String>): Flow<PagingData<Video>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                VideosPagingSource(videosApi = videosApi)
            }
        ).flow
    }
}