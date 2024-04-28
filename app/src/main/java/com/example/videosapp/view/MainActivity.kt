package com.example.videosapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.videosapp.dataStorage.VideosDao
import com.example.videosapp.model.Video
import com.example.videosapp.navigation.NavCoordinator
import com.example.videosapp.ui.theme.VideosAppTheme
import com.example.videosapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Hu AN on 28/04/2024
 */

// MainActivity, this is used to navigate to different views
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var dao: VideosDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // save video data into database, this just an example
        lifecycleScope.launch {
            dao.upsert(
                Video(
                    created_time = 0,
                    description = "database test",
                    id = "id",
                    thumbnail_240_url = "thumbnail_240_url",
                    thumbnail_480_url = "thumbnail_480_url",
                    thumbnail_720_url = "thumbnail_720_url",
                    title = "title"
                )
            )
        }

        setContent {
            VideosAppTheme {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background).fillMaxSize()) {
                    NavCoordinator(startDestination = viewModel.startDestination.value)
                }
            }
        }
    }
}