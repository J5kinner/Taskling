package com.jonah.taskling

import android.app.Application
import androidx.room.Room
import com.jonah.taskling.features.habit.data.HabitDao
import com.jonah.taskling.features.habit.data.HabitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHabitDatabase(app: Application): HabitDatabase {
        return Room.databaseBuilder(
            app,
            HabitDatabase::class.java,
            "habit_db"
        ).build()
    }

    @Provides
    fun provideHabitDao(db: HabitDatabase): HabitDao {
        return db.habitDao()
    }
}