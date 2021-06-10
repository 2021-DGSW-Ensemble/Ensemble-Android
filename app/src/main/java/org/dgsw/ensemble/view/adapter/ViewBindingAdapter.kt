package org.dgsw.ensemble.view.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("bindDate")
fun bindDate(view: TextView, time: Long) {
    view.text = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.US).format(Date(time))
}

@BindingAdapter("bindThumbnail")
fun bindThumbnail(view: ImageView, url: String?) {
    if (url == null || url.isEmpty()) return
    //if (true) return
    Glide.with(view)
        .load("https:$url")
        .into(view)
}