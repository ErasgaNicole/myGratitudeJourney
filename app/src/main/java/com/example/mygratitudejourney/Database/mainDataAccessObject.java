package com.example.mygratitudejourney.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import static androidx.room.OnConflictStrategy.REPLACE;
import com.example.mygratitudejourney.Models.notesTracker;

import java.util.List;

@Dao
public interface mainDataAccessObject
{
    @Insert (onConflict = REPLACE)
    void insertData(notesTracker newNotesTracker);

    @Query("SELECT * FROM gratitudeNotesTable ORDER BY uniqueID DESC")
    List<notesTracker> getAll();

    @Query("UPDATE gratitudeNotesTable SET tableTitle = :varTitle, tableNotes = :varNotes WHERE uniqueID = :varID")
    void updateData(int varID, String varTitle, String varNotes);

    @Delete
    void deleteData(notesTracker newNotesTracker);
}
