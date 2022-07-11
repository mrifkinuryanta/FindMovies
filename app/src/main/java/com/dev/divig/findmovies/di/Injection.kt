package com.dev.divig.findmovies.di

import android.content.Context
import com.dev.divig.findmovies.data.FindMoviesRepository
import com.dev.divig.findmovies.data.source.local.LocalDataSource
import com.dev.divig.findmovies.data.source.local.room.FindMoviesDatabase
import com.dev.divig.findmovies.data.source.remote.RemoteDataSource
import com.dev.divig.findmovies.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): FindMoviesRepository {

        val database = FindMoviesDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.findMoviesDao())
        val appExecutors = AppExecutors()

        return FindMoviesRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}