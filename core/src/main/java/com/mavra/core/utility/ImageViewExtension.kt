package com.mavra.core.utility

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String) {
    Glide
        .with(context)
        .load(url)
        .apply(RequestOptions().override(400, 400))
        .into(this)
}