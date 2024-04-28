package com.example.videosapp.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.videosapp.R
import com.example.videosapp.model.Video
import com.example.videosapp.utils.Dimens.mediumPadding1

/**
 * Created by Hu AN on 28/04/2024
 */

// Home view
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView(
    videos: LazyPagingItems<Video>,
    navigateToDetails: (Video) -> Unit
) {
    Column(
    modifier = Modifier
    .fillMaxSize()
    .padding(top = mediumPadding1)
    .statusBarsPadding()
    ) {

        Text(
            text = "Dailymotion", modifier = Modifier
                .fillMaxWidth()
                .padding(start = mediumPadding1)
                .basicMarquee(), fontSize = 18.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(mediumPadding1))

        ItemList(
            modifier = Modifier.padding(horizontal = mediumPadding1),
            videos = videos,
            onClick = navigateToDetails
        )
    }
}