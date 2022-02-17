package com.mavra.core.components.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.mavra.core.databinding.CoreToolbarBinding

class ToolbarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(
    context, attrs
) {
    private var binding: CoreToolbarBinding =
        CoreToolbarBinding.inflate(LayoutInflater.from(context), this, true)

}