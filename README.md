# Trackling

## Description

A simple and effective habit tracking app built with Kotlin and Jetpack Compose. This app allows users to:

*   Define and track daily habits.
*   Check off completed habits.
*   View progress and statistics.
*   Set reminders (optional).
*   Use an app widget for quick access (optional).

## Features

*   Habit creation and management
*   Habit completion tracking
*   Progress visualization (e.g., calendar view, charts)
*   Reminders (using AlarmManager or WorkManager)
*   App widget for quick habit checking

## Tech Stack

*   **Programming Language:** Kotlin
*   **UI Framework:** Jetpack Compose
*   **Architecture:** MVI (Model-View-Intent)
*   **Data Storage:** 
    *   Room Persistence Library
*   **Dependency Injection:** Hilt
*   **ViewModel Framework:**  Orbit MVI

## Data Storage Considerations

*   **Room:** Excellent for structured data, relationships, and complex queries. Ideal if you plan to have many habits, categories, or related data.
*   **SharedPreferences:** Suitable for small amounts of simple data like user preferences or basic habit status.
*   **DataStore:**  Modern solution for type-safe, asynchronous data storage. Good for key-value pairs or Proto DataStore for more complex data structures.

**Recommendation:** If you anticipate your app needing to handle a lot of data or complex relationships (e.g., habits, categories, rewards), Room is a robust and efficient choice. For simpler data needs, DataStore provides a more modern and safer approach than SharedPreferences.

## Dependency Injection

*   **Hilt:**  Android's recommended dependency injection library. Simplifies object creation and management, making your code more testable and maintainable.

## ViewModel Framework

*   **ViewModel:**  Part of Jetpack Lifecycle. Helps manage UI-related data and survives configuration changes (e.g., screen rotations).

## Project Structure

*   **ui:** Contains Compose UI components (screens, composables).
*   **data:**  Handles data access (repository, data sources).
*   **domain:**  Contains business logic (use cases, interactors).
*   **di:**  Dependency injection modules (Hilt).

## Getting Started

1.  Clone the repository.
2.  Open the project in Android Studio.
3.  Build and run the app.

## Future Improvements

*   Cloud synchronization
*   More sophisticated progress visualization
*   Habit streaks and rewards
*   Gamification features

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.