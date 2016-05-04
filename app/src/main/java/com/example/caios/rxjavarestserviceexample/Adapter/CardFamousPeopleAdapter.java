package com.example.caios.rxjavarestserviceexample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.caios.rxjavarestserviceexample.Model.FamousPeople;
import com.example.caios.rxjavarestserviceexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caios on 5/4/16.
 */
public class CardFamousPeopleAdapter extends RecyclerView.Adapter<CardFamousPeopleAdapter.ViewHolder> {
    List<FamousPeople> mItems;

    public CardFamousPeopleAdapter() {
        super();
        mItems = new ArrayList<FamousPeople>();
    }

    public void addData(List<FamousPeople> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    public void addData(FamousPeople item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.famouspeople_card_adapter, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        FamousPeople famousPeople = mItems.get(i);
        viewHolder.name.setText(famousPeople.getName());
        viewHolder.birthday.setText(String.format("birthday: %s", famousPeople.getBirthday()));
        viewHolder.about.setText(famousPeople.getAbout());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView birthday;
        public TextView about;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            birthday = (TextView) itemView.findViewById(R.id.birthday);
            about = (TextView) itemView.findViewById(R.id.about);
        }
    }
}
