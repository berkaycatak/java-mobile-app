package com.H5190058.berkay_catak_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.H5190058.berkay_catak_final.R;
import com.bumptech.glide.Glide;

public class GlideUtil {

    public static void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.logo)
                .centerCrop()
                .into(img);
    }
}
