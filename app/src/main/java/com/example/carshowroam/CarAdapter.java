package com.example.carshowroam;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    ArrayList<Car> list;
    OnItemSelected context;

    public interface OnItemSelected
    {
        void onItemClicked(int index);
    }

    public CarAdapter(@NonNull Context context, ArrayList<Car> list) {
        this.list = list;
        this.context = (OnItemSelected) context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivMakerList;
        TextView tvModelList;
        TextView tvOwnerList;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivMakerList = itemView.findViewById(R.id.ivMakerList);
            tvModelList = itemView.findViewById(R.id.tvModelList);
            tvOwnerList = itemView.findViewById(R.id.tvOwnerList);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // Toast.makeText((Context) context, ""+v.getTag(), Toast.LENGTH_SHORT).show();
                    context.onItemClicked(list.indexOf((Car) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(list.get(position)); // this is for click on single item
        holder.tvModelList.setText(list.get(position).getModel());
        holder.tvOwnerList.setText(list.get(position).getOwner());
        if(list.get(position).getMaker().equals("Mercedies"))
        {
            holder.ivMakerList.setImageResource(R.drawable.mercedes);
        }
        else if(list.get(position).getMaker().equals("Nissan"))
        {
            holder.ivMakerList.setImageResource(R.drawable.nissan);
        }
        else if(list.get(position).getMaker().equals("Volkswagen"))
        {
            holder.ivMakerList.setImageResource(R.drawable.volkswagen);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
