package com.jonah.taskling.features.habit.viewmodel

import com.jonah.taskling.features.habit.data.Habit

data class HabitState(
    val habits: List<Habit> = emptyList(),
    val isLoading: Boolean = false
)

sealed class HabitSideEffect {
    data class Toast(val text: String) : HabitSideEffect()
}