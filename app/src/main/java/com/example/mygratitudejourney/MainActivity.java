package com.example.mygratitudejourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.mygratitudejourney.Adapters.notesListAdapter;
import com.example.mygratitudejourney.Database.roomDataBase;
import com.example.mygratitudejourney.Models.notesTracker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    RecyclerView varRecyclerView;
    notesListAdapter varNotesListAdapter;
    List<notesTracker> varNotes = new ArrayList<>();
    roomDataBase varDataBase;
    FloatingActionButton varFloatingActionButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varRecyclerView = findViewById(R.id.recyclerHome);
        varFloatingActionButton = findViewById(R.id.floatingAddButton);

        varDataBase = roomDataBase.getInstance(this);

        varNotes = varDataBase.newMainDataAccessObject().getAll();

        updateRecycler(varNotes);

        varFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent varIntent = new Intent(MainActivity.this, notesTakerActivity.class);
                startActivityForResult(varIntent, 101);
            }
        });
    }

    private void updateRecycler(List<notesTracker> varNotes)
    {
        // THE LAYOUT
        varRecyclerView.setHasFixedSize(true);
        varRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        varNotesListAdapter = new notesListAdapter(MainActivity.this, varNotes, varNotesClickListener);
        varRecyclerView.setAdapter(varNotesListAdapter);
    }

    private final notesClickListener varNotesClickListener = new notesClickListener()
    {
        @Override
        public void onClick(notesTracker varNotesTracker) {

        }

        @Override
        public void onLongClick(notesTracker varNotesTracker, CardView varCardView) {

        }
    };
}