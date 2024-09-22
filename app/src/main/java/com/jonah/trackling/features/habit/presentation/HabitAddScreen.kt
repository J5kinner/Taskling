package com.jonah.trackling.features.habit.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jonah.trackling.features.habit.viewmodel.HabitViewModel

@Composable
fun HabitAddScreen(viewModel: HabitViewModel) {
    var habitName by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Habit Name Input Field
        OutlinedTextField(
            value = habitName,
            onValueChange = { habitName = it },
            label = { Text("Habit Name") },
            isError = showError,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // "Add Habit" Button
        Button(
            onClick = {
                if (habitName.isNotEmpty()) {
                    viewModel.addHabit(habitName)
                } else {
                    showError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Habit")
        }

        if (showError) {
            Text(
                text = "Habit name cannot be empty.",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}