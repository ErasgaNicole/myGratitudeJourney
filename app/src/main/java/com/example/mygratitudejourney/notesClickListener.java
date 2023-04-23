package com.example.mygratitudejourney;

import androidx.cardview.widget.CardView;

import com.example.mygratitudejourney.Models.notesTracker;

public interface notesClickListener
{
    void onClick(notesTracker varNotesTracker);
    void onLongClick(notesTracker varNotesTracker, CardView varCardView);

}
