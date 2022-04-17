package com.amarukael.bloodbags.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amarukael.bloodbags.Model.StokModel;
import com.amarukael.bloodbags.R;

import java.util.ArrayList;

public class StokAdapter extends RecyclerView.Adapter<StokAdapter.StokHolder> {
    private LayoutInflater inflater;
    private ArrayList<StokModel> imageModelStok;

    public StokAdapter(Context ctx, ArrayList<StokModel> imageModelStok){
        inflater = LayoutInflater.from(ctx);
        this.imageModelStok = imageModelStok;
    }

    @NonNull
    @Override
    public StokHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_stokrs, parent, false);
        return new StokHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StokHolder holder, int position) {
        holder.stok.setText(imageModelStok.get(position).getStok());
        holder.namars.setText(imageModelStok.get(position).getNamars());
        holder.jarakrs.setText(imageModelStok.get(position).getJarakrs());
        holder.jalanrs.setText(imageModelStok.get(position).getJalanrs());
        holder.gambarrs.setImageResource(imageModelStok.get(position).getGambarrs());
    }

    @Override
    public int getItemCount() {
        return imageModelStok.size();
    }

    public class StokHolder extends RecyclerView.ViewHolder {

        TextView namars, jalanrs, jarakrs, stok;
        ImageView gambarrs;


        public StokHolder(@NonNull View itemView) {
            super(itemView);
            namars = itemView.findViewById(R.id.txt_rs);
            jalanrs = itemView.findViewById(R.id.txt_jlnrs);
            jarakrs = itemView.findViewById(R.id.txt_jrkrs);
            stok = itemView.findViewById(R.id.stok);
            gambarrs = itemView.findViewById(R.id.img_rs);

        }
    }
}
