package com.example.videosapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.videosapp.R
import com.example.videosapp.model.Video
import com.example.videosapp.ui.theme.VideosAppTheme
import com.example.videosapp.utils.DateTools
import com.example.videosapp.utils.Dimens.extraSmallPadding
import com.example.videosapp.utils.Dimens.extraSmallPadding2
import com.example.videosapp.utils.Dimens.itemSize
import com.example.videosapp.utils.Dimens.smallIconSize

/**
 * Created by Hu AN on 28/04/2024
 */

// item view
@Composable
fun ItemView(
    modifier: Modifier = Modifier,
    video: Video,
    onClick: (() -> Unit)? = null
) {

    val context = LocalContext.current
    Row(
        modifier = modifier.clickable { onClick?.invoke() },

        ) {
        AsyncImage(
            modifier = Modifier
                .size(itemSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(video.thumbnail_240_url).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = extraSmallPadding)
                .height(itemSize)
        ) {
            Text(
                text = video.title,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.text_title),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(extraSmallPadding))

            Text(
                text = video.description.replace("<br />","\n"),
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = colorResource(id = R.color.text_title),
                maxLines = 2
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(extraSmallPadding2))
                Text(
                    text = video.id,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding2))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(smallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding))
                Text(
                    text = DateTools.getDate(video.created_time.toLong()),
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(extraSmallPadding2))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemViewPreview() {
    VideosAppTheme(dynamicColor = false) {
        ItemView(
            video = Video(
                created_time = 0,
                description = "",
                id = "",
                thumbnail_240_url = "",
                thumbnail_480_url = "",
                thumbnail_720_url = "",
                title = ""
            )
        )
    }
}