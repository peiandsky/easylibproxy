package com.peiandsky.easylibproxy

import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.io.File

object PicassoExt {
    fun display(imageFile: File, imageView: ImageView) {
        Picasso.get().load(imageFile).into(imageView)
    }

    fun display(imageHttpUrl: String, imageView: ImageView) {
        Picasso.get().load(imageHttpUrl).into(imageView)
    }

    fun display(imageR: Int, imageView: ImageView) {
        Picasso.get().load(imageR).into(imageView)
    }
}

