package com.emrahakbiyik.gts.Triggers;

/**
 * Created by emrahakbiyik on 13.04.2017.
 */


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emrahakbiyik.gts.Objects.Arac;
import com.emrahakbiyik.gts.R;

import java.util.List;

/**
 * Created by Alper on 14.5.2015.
 */
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView arac_adi;
        public TextView arac_plakasi;
        public ImageView arac_photo;
        public CardView card_view;


        public ViewHolder(View view) {
            super(view);

            card_view = (CardView)view.findViewById(R.id.card_view);
            arac_adi = (TextView)view.findViewById(R.id.arac_adi);
            arac_plakasi = (TextView)view.findViewById(R.id.arac_plaka);
            arac_photo = (ImageView)view.findViewById(R.id.arac_photo);

        }
    }

    List<Arac> aracList;
    public SimpleRecyclerAdapter(List<Arac> aracList) {

        this.aracList = aracList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.arac_cv_layout, parent, false);

        ViewHolder view_holder = new ViewHolder(v);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.arac_adi.setText(aracList.get(position).getRumuz());
        holder.arac_plakasi.setText(aracList.get(position).getPlaka());
        holder.arac_photo.setImageResource(aracList.get(position).getPhotoID()[0]);

    }

    @Override
    public int getItemCount() {
        return aracList.size();
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}