package com.mavra.shared.utility

import android.widget.ImageView
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide

fun ImageView.loadImage(url:String){
    Glide.with(context).load(url).into(this);
}