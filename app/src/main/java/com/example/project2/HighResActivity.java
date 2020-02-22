package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HighResActivity extends AppCompatActivity {

    String[] link = {"https://www.samsung.com/uk/smartphones/galaxy-a70/SM-A705FZKUBTU/",
                    "https://www.apple.com/shop/buy-iphone/iphone-11-pro",
                    "https://www.lg.com/us/mobile-phones/g8-thinq",
                    "https://www.samsung.com/us/mobile/galaxy-note10/",
                    "https://www.oneplus.com/7pro#/",
                    "https://www.oppo.com/en/smartphone-find_x/",
                    "https://store.google.com/product/pixel_3",
                    "https://www.mi.com/in/redmi-k20-pro/",
                    "https://www.samsung.com/us/mobile/galaxy-s10/",
                    "https://www.sonymobile.com/us/products/phones/xperia-10-plus/#gref"};

    Integer[] high_res_image = {R.drawable.galaxya70,
                                R.drawable.iphone11promax,
                                R.drawable.lgg8thinq,
                                R.drawable.note10plus,
                                R.drawable.oneplus7pro,
                                R.drawable.oppofindx,
                                R.drawable.pixel3xl,
                                R.drawable.redmik20pro,
                                R.drawable.s10,
                                R.drawable.xperia10plus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_res);
        // Sets the high-resolution image
        ImageView iv = findViewById(R.id.imageView);
        Intent intent = getIntent();
        final int position = intent.getIntExtra("itemno", 0);
        iv.setImageResource(high_res_image[position]);
        // Opens the website when image is clicked
        iv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction(Intent.ACTION_VIEW);
                in.addCategory(Intent.CATEGORY_BROWSABLE);
                in.setData(Uri.parse(link[position]));
                startActivity(in);
            }
        });
    }
}
