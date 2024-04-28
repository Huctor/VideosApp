package com.example.videosapp

import com.example.videosapp.di.AppModule
import com.example.videosapp.model.VideosResponse
import com.example.videosapp.service.VideosAPI
import com.example.videosapp.utils.Constants
import junit.framework.TestCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test

/**
 * Created by Hu AN on 28/04/2024
 */

// test ci module
class AppModuleTest {

    // test retrofit to get video data
    @Test
    fun response_retrofit_isCorrect() {
        var videosApi : VideosAPI = AppModule.provideApiInstance()
        var videosList : VideosResponse

        GlobalScope.launch {
            videosList = videosApi.getVideos(Constants.BASE_URL_PARAM, 10, 1)
            TestCase.assertEquals(true, videosList.list.count() > 0)
            TestCase.assertEquals(true, videosList.list[0].id.count() > 0)
            TestCase.assertEquals(true, videosList.list[0].description.count() > 0)
            TestCase.assertEquals(true, videosList.list[0].title.count() > 0)
            TestCase.assertEquals(true, videosList.list[0].created_time > 0)
        }
    }
}