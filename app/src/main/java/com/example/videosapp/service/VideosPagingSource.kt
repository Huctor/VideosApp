package com.example.videosapp.service

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.videosapp.model.Video
import com.example.videosapp.utils.Constants.BASE_URL_PARAM

/**
 * Created by Hu AN on 28/04/2024
 */

// load and manage resources
class VideosPagingSource(
    private val videosApi: VideosAPI
) : PagingSource<Int, Video>() {

    private var totalVideosCount = 10

    // load sources
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        val page = params.key ?: 1
        return try {
            val videosResponse = videosApi.getVideos(fields = BASE_URL_PARAM, limit = totalVideosCount, page = page)

            val videos = videosResponse.list
            LoadResult.Page(
                data = videos,
                nextKey = page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Video>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}