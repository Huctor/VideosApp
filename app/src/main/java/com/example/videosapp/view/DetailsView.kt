package com.example.videosapp.view


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.videosapp.ui.theme.VideosAppTheme

/**
 * Created by Hu AN on 28/04/2024
 */

// Details view
@Composable
fun DetailsView(
    navigateUp: () -> Unit
) {

    // display video full screen portrait
    PlayVideoView()

    // display video non full screen with back icon
    /* Column(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        DetailsTopBar(
            onBackClick = navigateUp
        )
        Spacer(modifier = Modifier.height(100.dp))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        PlayVideoView()
        Spacer(modifier = Modifier.height(50.dp))

    }*/
}

@Preview(showBackground = true)
@Composable
fun DetailsViewPreview() {
    VideosAppTheme(dynamicColor = false) {
        DetailsView() {
        }
    }
}