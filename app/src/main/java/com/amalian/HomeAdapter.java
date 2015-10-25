package com.amalian;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarek on 10/25/15.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeCategories> categories;
    private LayoutInflater layoutInflater;

    public HomeAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);

        categories = new ArrayList<>();
        categories.add(new HomeCategories("Fillers","Find out more about Fillers",R.drawable.fillers));
        categories.add(new HomeCategories("Skin Care","Find out more about Skin Care Products",R.drawable.skincare));
        categories.add(new HomeCategories("Doctors","Find out more about doctors we trust",R.drawable.doctors));

    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);

        View v = layoutInflater.inflate(R.layout.home_item, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {

        holder.itemImage.setImageResource(categories.get(position).photoId);
        holder.itemTitle.setText(categories.get(position).name);
        holder.itemDesc.setText(categories.get(position).desc);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView itemTitle;
        public TextView itemDesc;
        public ImageView itemImage;

        public ViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.homeItemTitle);
            itemDesc = (TextView) itemView.findViewById(R.id.homeItemDesc);
            itemImage = (ImageView) itemView.findViewById(R.id.homeItemImage);

        }
    }

}
