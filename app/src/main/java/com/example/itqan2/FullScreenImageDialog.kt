package com.example.itqan2

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.itqan2.R

class FullScreenImageDialog(context: Context, private val imageUrl: String) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_fullscreen_image)

        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        window?.setBackgroundDrawableResource(android.R.color.black)

        val imageView: ImageView = findViewById(R.id.fullscreenImageView)
        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(imageView)

        imageView.setOnClickListener { dismiss() } // إغلاق عند الضغط
    }
}
