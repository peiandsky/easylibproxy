package com.peiandsky.easylibproxy

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.QueueProcessingType


fun initImageLoader(context: Context) {
    val config = ImageLoaderConfiguration.Builder(context)
    config.threadPriority(Thread.NORM_PRIORITY - 2)
    config.denyCacheImageMultipleSizesInMemory()
    config.diskCacheFileNameGenerator(Md5FileNameGenerator())
    config.diskCacheSize(50 * 1024 * 1024) // 50 MiB

    config.tasksProcessingOrder(QueueProcessingType.FIFO)
    ImageLoader.getInstance().init(config.build())
}

private val cacheDisplayImageOptions: DisplayImageOptions = DisplayImageOptions.Builder()
    .cacheInMemory(true)
    .cacheOnDisk(true)
    .considerExifParams(true)
    .build()


fun displayImage(imageUri: String, imageView: ImageView) {
    if (imageUri.startsWith("http"))
        ImageLoader.getInstance().displayImage(imageUri, imageView, cacheDisplayImageOptions)
    else
        ImageLoader.getInstance().displayImage("file://$imageUri", imageView)
}

/**
 * 下载图片
 *
 * @param imageUri
 * @return
 */
fun downloadImage(imageUri: String): Bitmap? {
    return ImageLoader.getInstance().loadImageSync(imageUri)
}