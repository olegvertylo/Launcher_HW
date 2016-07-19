package com.example.olegvertylo.launcher_hw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

public class SomeAdapter extends RecyclerView.Adapter<SomeAdapter.ViewHolder> implements Filterable {
    private String[] data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
        }
    }

    public SomeAdapter(String[] data) {
        this.data = data;
    }

    @Override
    public SomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_two, parent, true);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
