package com.mavra.core.components.custom_views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.mavra.core.R
import com.mavra.core.databinding.CoreToolbarBinding

@SuppressLint("Recycle", "CustomViewStyleable")
class ToolbarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(
    context, attrs
) {
    private var binding: CoreToolbarBinding =
        CoreToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomToolbar)
        attributes.apply {
            binding.customToolbar.title = getString(R.styleable.CustomToolbar_android_text)
        }
    }
}