# Pokédex – Generation 1 (Jetpack Compose)

Native Android application built with Jetpack Compose that displays Generation 1 Pokémon using live data from the PokéAPI.

## Features
- Browse all Generation 1 Pokémon
- Search Pokémon by name
- Sort Pokémon (A–Z, Z–A)
- Filter Pokémon by type
- Manage a personal backpack
- Add / remove Pokémon
- Mark Pokémon as favourite
- Rate Pokémon (1–5 stars)

## Tech Stack
- Kotlin
- Jetpack Compose
- MVVM Architecture
- ViewModel + Repository
- Kotlin Coroutines & Flow
- Room Database
- PokéAPI (https://pokeapi.co)

## Installation & Run Instructions
1. Clone the repository
2. Open the project in Android Studio
3. Let Gradle sync complete
4. Run the app on an emulator or physical device

## Architecture Overview
- UI layer built with Jetpack Compose
- ViewModel handles UI state
- Repository manages data from API and local database
- Room used for persistence (Backpack)

## API Usage
- Pokémon data fetched from the public PokéAPI
- Only Generation 1 Pokémon are used

## Assumptions & Limitations
- Internet connection required for initial Pokémon data
- UI optimized for portrait mode
- Only Generation 1 Pokémon supported

## Screenshots
Screenshots are provided.
<img width="1080" height="2400" alt="Screenshot_20251228_011501" src="https://github.com/user-attachments/assets/53106944-d1d3-4461-8b0a-22096ea887bd" />
<img width="1080" height="2400" alt="Screenshot_20251228_011514" src="https://github.com/user-attachments/assets/7076986d-ca94-4cbb-87f2-3d2adc7371db" />


