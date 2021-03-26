package com.example.offlinecache

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.offlinecache.data.Restaurant
import com.example.offlinecache.databinding.RestaurantItemBinding

class RestaurantAdapter :
    ListAdapter<Restaurant, RestaurantAdapter.MyViewHolder>(RestaurantComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RestaurantItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = getItem(position)
        if (current != null) {
            holder.bind(current)
        }
    }

    class MyViewHolder(private val binding: RestaurantItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {

            binding.apply {
                Glide.with(itemView)
                    .load(restaurant.logo)
                    .into(imageViewLogo)

                textViewName.text = restaurant.name
                textViewAddress.text = restaurant.address
                textViewType.text = restaurant.type

            }

        }

    }

    class RestaurantComparator : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean =
            oldItem == newItem

    }


}