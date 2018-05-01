package com.example.oscar.htools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

public class HToolsAdapter extends RecyclerView.Adapter<HToolsAdapter.HToolsViewHolder >
{
    private final ArrayList<String> mFloorList;
    LayoutInflater mInflater;



    public  HToolsAdapter(Context context, ArrayList<String>  floorList )
    {
        mInflater = LayoutInflater.from(context);
        this.mFloorList = floorList;
    }

    @Override
    public HToolsAdapter.HToolsViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View mItemView = mInflater.inflate(R.layout.items,parent,false);
        return new HToolsViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(HToolsAdapter.HToolsViewHolder holder, int position)
    {

            String title = mFloorList.get(position);
            holder.floorNumber.setText(title);

    }

    @Override
    public int getItemCount()
    {
        return mFloorList.size();
    }


    public class HToolsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView floorNumber;
        final HToolsAdapter mAdapter;
        CardView mCardView;

        public HToolsViewHolder(View itemView, HToolsAdapter adapter)
        {
            super(itemView);
            mCardView = itemView.findViewById(R.id.cardview);
            floorNumber =  itemView.findViewById(R.id.floorNumber);
            mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view)
        {

            Context context = view.getContext();
            view.setBackgroundColor(ContextCompat.getColor(context,R.color.selectedRow));
            TextView tv = view.findViewById(R.id.floorNumber);
            tv.setPaintFlags(tv.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            Toast.makeText(itemView.getContext(), floorNumber.getText(), Toast.LENGTH_SHORT).show();
            String sharePrefName = floorNumber.getText().toString().replaceAll("\\s+","");
            Intent intent = new Intent(context,DisplayLinen.class);
            intent.putExtra("floor",sharePrefName);
            intent.putExtra("viewPosition",getAdapterPosition());
            context.startActivity( intent);
        }
    }

}
