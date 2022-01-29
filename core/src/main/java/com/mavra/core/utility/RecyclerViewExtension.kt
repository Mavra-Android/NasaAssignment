package com.mavra.core.utility

import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


fun Fragment.linearLayoutManagerVertical() = lazy {
    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
}

fun Fragment.linearLayoutManagerHorizontal() = lazy {
    LinearLayoutManager(context, RecyclerView.VERTICAL, false)
}

fun Fragment.dividerDecorationVertical(@DrawableRes separatorDrawable: Int? = null) = lazy {
    DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
        separatorDrawable?.let {
            setDrawable(AppCompatResources.getDrawable(requireContext(),separatorDrawable)!!)
        }
    }
}

fun RecyclerView.attach(
    adapter: RecyclerView.Adapter<*>,
    layoutManager: RecyclerView.LayoutManager,
    decoration: List<DividerItemDecoration> = listOf()
) {
    this.adapter = adapter
    this.layoutManager = layoutManager
    decoration.forEach(this::addItemDecoration)
    detach()
}

fun RecyclerView.detach() {
    ViewTreeLifecycleOwner.get(this)?.lifecycle?.addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            adapter = null
            layoutManager = null
            clearOnScrollListeners()
            val decoratorCount = itemDecorationCount
            if (decoratorCount <= 0) return
            for (i in 0 until decoratorCount) {
                removeItemDecoration(getItemDecorationAt(0))
            }
        }
    })
}
