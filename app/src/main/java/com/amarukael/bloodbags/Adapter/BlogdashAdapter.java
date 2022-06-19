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
import com.bumptech.glide.Glide;

import java.util.List;

public class BlogdashAdapter extends RecyclerView.Adapter<BlogdashAdapter.MyViewHolder>{
    Context context;
    List<BlogdashModel> blogdashModels;


    public BlogdashAdapter(Context ctx, List<BlogdashModel> blogdashList){

        this.context = ctx;
        blogdashModels = blogdashList;
    }

    @NonNull
    @Override
    public BlogdashAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BlogdashModel blogdashModel = blogdashModels.get(position);

        holder.time.setText(blogdashModel.getName());
        holder.date.setText(blogdashModel.getDate());
        Glide.with(context).load(blogdashModel.getImage_drawable()).into(holder.iv);
        holder.iv.setClipToOutline(true);

    }

    @Override
    public int getItemCount() {
        return blogdashModels.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView time,date;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            date = itemView.findViewById(R.id.txdate);
        }

    }
}
