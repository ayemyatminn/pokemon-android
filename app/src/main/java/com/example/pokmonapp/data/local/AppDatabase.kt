package com.example.pokmonapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [BackpackEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun backpackDao(): BackpackDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pokedex_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}