package com.example.videosapp.view

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.videosapp.utils.Constants.VIDEO_URL
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

/**
 * Created by Hu AN on 28/04/2024
 */

// play video
@Composable
fun PlayVideoView(){
    val context = LocalContext.current
    val url = VIDEO_URL
    val exoPlayer = ExoPlayer.Builder(context).build()
    val mediaItem = MediaItem.fromUri(Uri.parse(url))
    exoPlayer.setMediaItem(mediaItem)

    AndroidView(
        factory = { mContext ->
            StyledPlayerView(mContext).apply {
                // add these two lines to play video automatically
                // exoPlayer.prepare()
                // exoPlayer.playWhenReady= true
                player = exoPlayer
            }
        },
        modifier = Modifier
            .fillMaxSize()
    )
}
