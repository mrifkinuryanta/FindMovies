package com.dev.divig.findmovies.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.divig.findmovies.data.source.local.entity.MovieEntity
import com.dev.divig.findmovies.data.source.local.entity.TvShowsEntity

@Database(
    entities = [MovieEntity::class, TvShowsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FindMoviesDatabase : RoomDatabase() {
    abstract fun findMoviesDao(): FindMoviesDao

    companion object {
        @Volatile
        private var INSTANCE: FindMoviesDatabase? = null

        fun getInstance(context: Context): FindMoviesDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: Room.databaseBuilder(
                        context.applicationContext,
                        FindMoviesDatabase::class.java,
                        "FindMovies.db"
                    ).build()
            }
    }
}