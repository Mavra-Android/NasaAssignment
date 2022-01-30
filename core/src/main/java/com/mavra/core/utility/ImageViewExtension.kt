package com.mavra.core.utility

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.mavra.core.components.ImageViewComponent

fun ImageViewComponent.loadImage(url: String) {
    Glide
        .with(context)
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}