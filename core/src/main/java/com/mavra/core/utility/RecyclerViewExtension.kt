package com.mavra.core.utility

import android.os.Handler
import android.os.Looper
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun Fragment.linearLayoutManagerVertical() = lazy {
    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
}

fun Fragment.linearLayoutManagerHorizontal() = lazy {
    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
}

fun Fragment.dividerDecorationVertical(@DrawableRes separatorDrawable: Int? = null) = lazy {
    DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
        separatorDrawable?.let {
            setDrawable(AppCompatResources.getDrawable(requireContext(), separatorDrawable)!!)
        }
    }
}

fun RecyclerView.attach(
    adapter: RecyclerView.Adapter<*>,
    layoutManager: RecyclerView.LayoutManager,
    decoration: List<DividerItemDecoration> = listOf(),
    viewLifecycleOwner: LifecycleOwner
) {
    this.adapter = adapter
    this.layoutManager = layoutManager
    decoration.forEach(this::addItemDecoration)
    detach(viewLifecycleOwner)
}

fun RecyclerView.detach(viewLifecycleOwner: LifecycleOwner) {
    viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            Handler(Looper.getMainLooper()).post {
                layoutManager = null
                adapter = null
                clearOnScrollListeners()
                val decoratorCount = itemDecorationCount
                if (decoratorCount <= 0) return@post
                for (i in 0 until decoratorCount) {
                    removeItemDecoration(getItemDecorationAt(0))
                }
            }
        }
    })
}
