package com.example.mygratitudejourney.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "gratitudeNotesTable")
public class notesTracker implements Serializable
{
    @PrimaryKey (autoGenerate = true)
    int uniqueID = 0;

    @ColumnInfo (name = "tableTitle")
    String uniqueTitle = "";

    @ColumnInfo (name = "tableNotes")
    String uniqueNotes = "";

    @ColumnInfo (name = "tableDate")
    String date = "";

    @ColumnInfo (name = "tablePinned")
    boolean isPinned = false;

    public int getUniqueID()
    {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID)
    {

        this.uniqueID = uniqueID;
    }

    public String getUniqueTitle()
    {
        return uniqueTitle;
    }

    public void setUniqueTitle(String uniqueTitle)
    {
        this.uniqueTitle = uniqueTitle;
    }

    public String getUniqueNotes()
    {
        return uniqueNotes;
    }

    public void setUniqueNotes(String uniqueNotes)
    {
        this.uniqueNotes = uniqueNotes;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public boolean isPinned()
    {
        return isPinned;
    }

    public void setPinned(boolean pinned)
    {
        isPinned = pinned;
    }
}
