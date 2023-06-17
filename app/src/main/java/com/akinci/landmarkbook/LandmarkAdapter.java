package com.akinci.landmarkbook;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akinci.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class Landmarkadapter extends RecyclerView.Adapter<Landmarkadapter.Landmarkholder> {
    ArrayList<Landmark> landmarkArrayList;
    public Landmarkadapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }


    @NonNull
    @Override
    public Landmarkholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new Landmarkholder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Landmarkholder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark",landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }

    public class Landmarkholder extends RecyclerView.ViewHolder{
        private RecyclerRowBinding binding;

        public Landmarkholder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
