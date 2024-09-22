package com.jonah.trackling.features.habit.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jonah.trackling.features.habit.viewmodel.HabitViewModel

@Composable
fun HabitListScreen(viewModel: HabitViewModel, paddingValues: PaddingValues) {
    val state = viewModel.container.stateFlow.collectAsState()

    Column(Modifier.padding(paddingValues)) {
        Text("Completed ${state.value.habits.count { it.completed }} of ${state.value.habits.size}")
        HabitAddScreen(viewModel)
        LazyColumn {
            items(state.value.habits) { habit ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(habit.name)
                    Checkbox(checked = habit.completed, onCheckedChange = {
                        viewModel.completeHabit(habit)
                    })
                }
            }
        }

    }
}