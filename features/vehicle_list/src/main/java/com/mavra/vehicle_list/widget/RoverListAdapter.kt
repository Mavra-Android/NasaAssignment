package com.mavra.vehicle_list.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mavra.core.utility.loadImage
import com.mavra.domain.model.DomainPhoto
import com.mavra.vehicle_list.databinding.RowRoverBinding

class RoverListAdapter(
    private val onEvent: (Event) -> Unit
) : ListAdapter<DomainPhoto, RoverListAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: RowRoverBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(domainPhoto: DomainPhoto) {
            binding.ivRover.loadImage(domainPhoto.imagePath)
            binding.tvDate.text = domainPhoto.date
            binding.root.setOnClickListener {
                onEvent.invoke(Event.OnShowDetail(domainPhoto))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowRoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffCallback : DiffUtil.ItemCallback<DomainPhoto>() {

        override fun areItemsTheSame(oldItem: DomainPhoto, newItem: DomainPhoto) =
            oldItem.imageId == newItem.imageId

        override fun areContentsTheSame(oldItem: DomainPhoto, newItem: DomainPhoto) =
            oldItem == newItem
    }

    sealed class Event {
        data class OnShowDetail(
            val photo: DomainPhoto
        ) : Event()
    }
}
