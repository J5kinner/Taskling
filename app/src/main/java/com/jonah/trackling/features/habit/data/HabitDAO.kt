package com.jonah.trackling.features.habit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HabitDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabit(habit: Habit)

    @Update
    suspend fun updateHabit(habit: Habit)

    @Query("SELECT * FROM habit_table")
    suspend fun getAllHabits(): List<Habit>

    @Query("SELECT * FROM habit_table WHERE date = :date")
    suspend fun getHabitsForDate(date: String): List<Habit>
}