package com.example.videosapp.di
import android.app.Application
import androidx.room.Room
import com.example.videosapp.dataStorage.VideosDao
import com.example.videosapp.dataStorage.VideosDatabase
import com.example.videosapp.repository.VideosRepository
import com.example.videosapp.repository.VideosRepositoryImpl
import com.example.videosapp.service.VideosAPI
import com.example.videosapp.usecase.VideosInvoke
import com.example.videosapp.model.VideosUseCases
import com.example.videosapp.utils.Constants.BASE_URL
import com.example.videosapp.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Hu AN on 28/04/2024
 */

// dependency injection
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // provide VideosAPI
    @Provides
    @Singleton
    fun provideApiInstance(): VideosAPI {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VideosAPI::class.java)
    }

    // provide video respository
    @Provides
    @Singleton
    fun provideVideosRepository(
        videosApi: VideosAPI,
    ): VideosRepository {
        return VideosRepositoryImpl(videosApi)
    }

    // provide video special use case
    @Provides
    @Singleton
    fun provideVideosUseCases(
        videosRepository: VideosRepository
    ): VideosUseCases {
        return VideosUseCases(
            getVideos = VideosInvoke(videosRepository)
        )
    }

    //provide videos database
    @Provides
    @Singleton
    fun provideVideosDatabase(
        application: Application
    ): VideosDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = VideosDatabase::class.java,
            name = DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    // provide video Dao
    @Provides
    @Singleton
    fun provideVideosDao(
        videosDatabase: VideosDatabase
    ): VideosDao = videosDatabase.videoDao
}