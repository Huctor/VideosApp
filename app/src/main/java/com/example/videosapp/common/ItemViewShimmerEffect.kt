package com.example.videosapp.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.videosapp.R
import com.example.videosapp.utils.Dimens.extraSmallPadding
import com.example.videosapp.utils.Dimens.itemSize
import com.example.videosapp.utils.Dimens.mediumPadding1

/**
 * Created by Hu AN on 28/04/2024
 */

// shimmer effect
fun Modifier.shimmerEffect() = then(composed {
    val transition = rememberInfiniteTransition()
    val alpha = transition.animateFloat(
        initialValue = 0.2f, targetValue = 0.9f, animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    ).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
})

// item shimmer effect
@Composable
fun ItemViewShimmerEffect(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(itemSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect()
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = extraSmallPadding)
                .height(itemSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = mediumPadding1)
                    .shimmerEffect()
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(horizontal = mediumPadding1)
                        .height(15.dp)
                        .shimmerEffect()
                )
            }
        }
    }
}
