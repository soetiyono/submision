package com.notur.submitionsatu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title = findViewById(R.id.tv_title);
        TextView desc = findViewById(R.id.tv_desc);
        ImageView img = findViewById(R.id.image_detail);

        Intent intent = getIntent();
        final String iTitle = intent.getStringExtra("title");
        final String iDesc = intent.getStringExtra("desc");
        final String iPhoto = intent.getStringExtra("photo");

        title.setText(iTitle);
        desc.setText(iDesc);
        Glide.with(this).load(iPhoto).into(img);


    }
}
