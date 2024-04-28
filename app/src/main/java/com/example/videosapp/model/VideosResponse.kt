package com.example.videosapp.model

/**
 * Created by Hu AN on 28/04/2024
 */

// video response model
data class VideosResponse(
    val explicit: Boolean,
    val has_more: Boolean,
    val limit: Int,
    val list: List<Video>,
    val page: Int,
    val total: Int
)