package com.example.videosapp.dataStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.videosapp.model.Video

/**
 * Created by Hu AN on 28/04/2024
 */

// video abstract class for database
@Database(entities = [Video::class],version = 1,)
abstract class VideosDatabase : RoomDatabase() {
    abstract val videoDao: VideosDao
}