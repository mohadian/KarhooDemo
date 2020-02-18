package com.example.karhoodemo.presentation.common.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.karhoodemo.R

/**
 * Data Binding adapters specific to the app.
 */
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter(value = ["imageUrl"], requireAll = false)
    fun bindImage(imageView: ImageView, url: String?) {
        val options = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_location_placeholder)
            .error(R.drawable.ic_location_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        Glide.with(imageView.context).load(url).apply(options).into(imageView)
    }
}
