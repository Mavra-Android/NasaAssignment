package com.mavra.vehicle_list.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mavra.domain.model.DomainPhoto
import com.mavra.core.utility.loadImage
import com.mavra.vehicle_list.databinding.RowRoverBinding

class RoverListAdapter : ListAdapter<DomainPhoto,RoverListAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(val binding: RowRoverBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowRoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(getItem(position)){
                binding.ivRover.loadImage(name)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<DomainPhoto>() {

        override fun areItemsTheSame(oldItem: DomainPhoto, newItem: DomainPhoto) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: DomainPhoto, newItem: DomainPhoto) =
            oldItem == newItem
    }
}
