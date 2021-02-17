package com.anilejder.apps.pinsoft.binding;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;

public class ImageAdapter {

    @BindingAdapter("loadImage")
    public static void loadImage(ImageView imageView, String url) {

        if (TextUtils.isEmpty(url))
            return;

        Context context = imageView.getContext();

        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStyle(CircularProgressDrawable.DEFAULT);
        circularProgressDrawable.setCenterRadius(24f);

        Glide.with(context)
                .load(url)
                .placeholder(circularProgressDrawable)
                .into(imageView);
    }
}