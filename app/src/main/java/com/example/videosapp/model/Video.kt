package com.example.videosapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Hu AN on 28/04/2024
 */

// video model, also for database
@Entity
data class Video(
    val created_time: Int,
    val description: String,
    @PrimaryKey val id: String,
    val thumbnail_240_url: String,
    val thumbnail_480_url: String,
    val thumbnail_720_url: String,
    val title: String
)