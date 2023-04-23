package com.example.mygratitudejourney.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygratitudejourney.Models.notesTracker;
import com.example.mygratitudejourney.R;
import com.example.mygratitudejourney.notesClickListener;

import java.util.List;

public class notesListAdapter extends RecyclerView.Adapter<notesViewHolder>
{
    Context varContext;
    java.util.List<notesTracker> varList;
    notesClickListener listener;

    public notesListAdapter(Context varContext, List<notesTracker> varList, notesClickListener listener) {
        this.varContext = varContext;
        this.varList = varList;
        this.listener = listener;
    }



    @NonNull
    @Override
    public notesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new notesViewHolder(LayoutInflater.from(varContext).inflate(R.layout.notes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull notesViewHolder holder, int position)
    {
        holder.varTitleText.setText(varList.get(position).getUniqueTitle());
        holder.varTitleText.setSelected(true);

        holder.textViewQuestion.setText(varList.get(position).getUniqueNotes());

        holder.textViewDate.setText(varList.get(position).getDate());
        holder.textViewDate.setSelected((true));

        holder.varnotesContainer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                listener.onClick(varList.get(holder.getAdapterPosition()));
            }
        });

        holder.varnotesContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onLongClick(varList.get(holder.getAdapterPosition()), holder.varnotesContainer);
                return true;
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return varList.size();
    }
}

class notesViewHolder extends RecyclerView.ViewHolder
{
    CardView varnotesContainer;
    TextView varTitleText, varLevelText, textViewQuestion, textViewDate;
    public notesViewHolder(@NonNull View itemView)
    {
        super(itemView);
        varnotesContainer = itemView.findViewById(R.id.notesContainer);
        varTitleText = itemView.findViewById(R.id.titleText);
        varLevelText = itemView.findViewById(R.id.levelText);
        textViewQuestion = itemView.findViewById(R.id.textViewQuestion);
        textViewDate = itemView.findViewById(R.id.textViewDate);

    }
}
