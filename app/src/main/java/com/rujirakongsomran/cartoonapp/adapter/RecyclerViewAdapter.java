package com.rujirakongsomran.cartoonapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rujirakongsomran.cartoonapp.R;
import com.rujirakongsomran.cartoonapp.databinding.AnimeRowItemBinding;
import com.rujirakongsomran.cartoonapp.model.Anime;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Anime> mData;
    RequestOptions options;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.loading_shape)
                .error(R.drawable.loading_shape);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return new MyViewHolder(
                AnimeRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.binding.tvAnimeName.setText(mData.get(position).getName());
        holder.binding.tvRating.setText(mData.get(position).getRating());
        holder.binding.tvStudio.setText(mData.get(position).getStudio());
        holder.binding.tvCategory.setText(mData.get(position).getCategories());

        // Load Image from the internet and set it into ImageView using Glide
        Glide.with(mContext).load(mData.get(position).getImg()).apply(options).into(holder.binding.ivThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private AnimeRowItemBinding binding;


        public MyViewHolder(AnimeRowItemBinding animeRowItemBinding) {
            super(animeRowItemBinding.getRoot());
            this.binding = animeRowItemBinding;
        }
    }
}
