package com.example.videosapp.dataStorage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.videosapp.model.Video
import kotlinx.coroutines.flow.Flow

/**
 * Created by Hu AN on 28/04/2024
 */

// database operations
@Dao
interface VideosDao {

    // insert data into database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Video)

    // delete data from database
    @Delete
    suspend fun delete(article: Video)

    // get item video from database
    @Query("SELECT * FROM Video")
    fun getVideo(): Flow<List<Video>>
}