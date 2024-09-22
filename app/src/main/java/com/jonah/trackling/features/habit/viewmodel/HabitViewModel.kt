package com.jonah.trackling.features.habit.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jonah.trackling.features.habit.data.Habit
import com.jonah.trackling.features.habit.data.HabitDao
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HabitViewModel @Inject constructor(
    private val habitDao: HabitDao
) : ViewModel(), ContainerHost<HabitState, HabitSideEffect> {

    override val container = container<HabitState, HabitSideEffect>(HabitState())

    init {
        getHabits()
    }

    fun addHabit(name: String) = intent {
        val newHabit = Habit(
            name = name,
            date = getCurrentDate(),
            completed = false
        )
        habitDao.insertHabit(newHabit)
        val updatedHabits = habitDao.getAllHabits()

        reduce {
            state.copy(habits = updatedHabits)
        }
    }

    fun loadHabits(date: String) = intent {
        val habits = habitDao.getHabitsForDate(date)

        reduce {
            state.copy(habits = habits)
        }
    }

    private fun getHabits() = intent {
        val habits = habitDao.getAllHabits()
        Log.d("HabitViewModel", "Current habits: ${habits.toString()}")


        reduce { state.copy(habits = habits) }
    }

    fun completeHabit(habit: Habit) = intent {
        habitDao.updateHabit(habit.copy(completed = true))
        val updatedHabits = habitDao.getAllHabits()

        reduce {
            state.copy(habits = updatedHabits)
        }
    }

    private fun getCurrentDate(): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return formatter.format(Date())
    }
}
