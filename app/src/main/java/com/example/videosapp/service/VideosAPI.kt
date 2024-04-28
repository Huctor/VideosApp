package com.example.videosapp.service

import com.example.videosapp.model.VideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Hu AN on 28/04/2024
 */

// videoAPI interface
interface VideosAPI {

    // REST API -> Get
    @GET("/videos")
    suspend fun getVideos(
        @Query("fields") fields: String,
        @Query("limit") limit: Int,
        @Query("page") page: Int
    ): VideosResponse
}