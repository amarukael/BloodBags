package com.amarukael.bloodbags.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amarukael.bloodbags.Model.BlogdashModel;
import com.amarukael.bloodbags.R;

import java.util.ArrayList;

public class BlogdashAdapter extends RecyclerView.Adapter<BlogdashAdapter.MyViewHolder>{
    private LayoutInflater inflater;
    private ArrayList<BlogdashModel> imageModelArrayList;


    public BlogdashAdapter(Context ctx, ArrayList<BlogdashModel> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @NonNull
    @Override
    public BlogdashAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.time.setText(imageModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
        }

    }
}
