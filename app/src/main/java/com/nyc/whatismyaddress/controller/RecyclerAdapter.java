package com.nyc.whatismyaddress.controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nyc.whatismyaddress.DisplayActivity;
import com.nyc.whatismyaddress.R;
import com.nyc.whatismyaddress.model.RecyclerModel;
import com.nyc.whatismyaddress.view.RecyclerViewHolder;

import java.util.List;

/**
 * Created by c4q on 11/21/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<RecyclerModel> modelList;

    public RecyclerAdapter(List<RecyclerModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new RecyclerViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        final RecyclerModel model= modelList.get(position);
        holder.onBind(model);
        holder.getItem().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DisplayActivity.class);
                intent.putExtra("item", model.getEmail());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
