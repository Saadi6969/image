package com.carpal.myapplication

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

object ImageUtils {
    fun loadImage(context: Context, uri: Uri, imageView: ImageView) {
        Glide.with(context)
            .load(uri)
            .into(imageView)
    }
}
