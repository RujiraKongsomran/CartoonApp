package com.rujirakongsomran.cartoonapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rujirakongsomran.cartoonapp.R;
import com.rujirakongsomran.cartoonapp.databinding.ActivityAnimeBinding;

public class AnimeActivity extends AppCompatActivity {

    ActivityAnimeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_anime);

        binding = ActivityAnimeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Get Intent
        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String category = getIntent().getExtras().getString("anime_category");
        String rating = getIntent().getExtras().getString("anime_rating");
        String img = getIntent().getExtras().getString("anime_img");

        binding.collapsingToolbarLayout.setTitleEnabled(true);

        binding.aaTvAnimeName.setText(name);
        binding.aaTvCategory.setText(category);
        binding.aaTvDescription.setText(description);
        binding.aaTvRating.setText(rating);
        binding.aaTvStudio.setText(studio);
        binding.collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        Glide.with(this).load(img).apply(requestOptions).into(binding.aaIvThumbnail);


    }
}