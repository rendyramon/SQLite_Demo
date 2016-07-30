package com.example.sonet.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sonet on 7/30/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<DataProvider> dataProviders;

    public RecyclerAdapter(ArrayList<DataProvider> dataProviders) {
        this.dataProviders = dataProviders;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.imageView_contryFlag.setImageResource(dataProviders.get(position).getImgId());
        holder.txt_countryName.setText(dataProviders.get(position).getCountryName());
        holder.txt_capitalName.setText(dataProviders.get(position).getCountryCapital());

    }

    @Override
    public int getItemCount() {
        return dataProviders.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txt_countryName;
        TextView txt_capitalName;
        ImageView imageView_contryFlag;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            txt_countryName = (TextView) itemView.findViewById(R.id.countyNameTextView);
            txt_capitalName = (TextView) itemView.findViewById(R.id.capitalNameTextView);
            imageView_contryFlag = (ImageView) itemView.findViewById(R.id.countryFlagImage);
        }
    }
}
