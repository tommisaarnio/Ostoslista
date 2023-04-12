package com.tommisaarnio.ostoslista;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StuffViewHolder extends RecyclerView.ViewHolder {
    TextView itemName, itemNote;

    ImageView removeImage, editImage;

    EditText editName, editNote;


    public StuffViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.txtItemName);
        itemNote = itemView.findViewById(R.id.txtNote);
        removeImage = itemView.findViewById(R.id.imgRemove);
        editImage = itemView.findViewById(R.id.imgEdit);
        editName = itemView.findViewById(R.id.editName);
        editNote = itemView.findViewById(R.id.editNote);
    }
}
