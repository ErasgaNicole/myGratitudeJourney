package com.example.mygratitudejourney.Database;

// Imports
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mygratitudejourney.Models.notesTracker;

// Database
@Database(entities = notesTracker.class, version = 1, exportSchema = false)
public abstract class roomDataBase extends RoomDatabase
{
    // New class of roomDataBase
    private static roomDataBase newDataBase;

    // The database name
    private static String databaseName = "NOTE APPLICATION";


    public synchronized static roomDataBase getInstance(Context newContext)
    {
        if (newDataBase == null)
        {
            newDataBase = Room.databaseBuilder(newContext.getApplicationContext(), roomDataBase.class, databaseName)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return newDataBase;
    }

    // Abstract Class
    public abstract mainDataAccessObject newMainDataAccessObject();
}
