package com.tommisaarnio.ostoslista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StuffListAdapter extends RecyclerView.Adapter<StuffViewHolder> {

    private Context context;
    private ArrayList<Stuff> items = new ArrayList<>();

    public StuffListAdapter(Context context, ArrayList<Stuff> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public StuffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StuffViewHolder(LayoutInflater.from(context).inflate(R.layout.stuff_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StuffViewHolder holder, int position) {
        Stuff item = items.get(position);
        holder.itemName.setText(item.getName());
        holder.itemNote.setText(item.getNote());
        holder.editName.setText(items.get(position).getName());
        holder.editNote.setText(items.get(position).getNote());

        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            StuffStorage.getInstance().removeItem(items.get(pos).getName());
            notifyItemRemoved(pos);

        });

        holder.editImage.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();

            if (holder.editName.getVisibility() == View.VISIBLE) {
                Stuff stuff = StuffStorage.getInstance().getStuffByName(pos);
                stuff.setNote(holder.editNote.getText().toString());
                stuff.setName(holder.editName.getText().toString());
                holder.editName.setVisibility(View.GONE);
                holder.editNote.setVisibility(View.GONE);
                notifyDataSetChanged();
                StuffStorage.getInstance().saveStuff(context);
            }
            else {
            holder.editName.setVisibility(View.VISIBLE);
            holder.editNote.setVisibility(View.VISIBLE);
        }

        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
