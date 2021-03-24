package com.ardnn.tugas3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListProgrammingLanguageAdapter extends RecyclerView.Adapter<ListProgrammingLanguageAdapter.ListViewHolder> {

    private ArrayList<ProgrammingLanguage> listData;
    private OnItemClickCallback onItemClickCallback;


    public ListProgrammingLanguageAdapter(ArrayList<ProgrammingLanguage> list) {
        this.listData = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_datas, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ProgrammingLanguage pl = listData.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pl.getImage())
                .apply(new RequestOptions().override(1080,1080))
                .into(holder.imgPhoto);
        holder.tvTitle.setText(pl.getName());

        holder.itemView.setOnClickListener(v -> {
            onItemClickCallback.onItemClicked(listData.get(holder.getAdapterPosition()));
        });

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_name);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ProgrammingLanguage data);
    }

}
