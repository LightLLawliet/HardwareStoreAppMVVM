package com.example.hardwarestoreappmvvm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.data.ManageResources
import com.example.hardwarestoreappmvvm.data.cache.StoreCache

class StoreFrontItemAdapter(
    private val manageResources: ManageResources,
    var items: List<StoreCache>,
    private val viewModel: StoreViewModel
) : RecyclerView.Adapter<StoreFrontItemAdapter.StoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_front_item, parent, false)
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val storeItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.frontName).text = storeItem.name
        holder.itemView.findViewById<TextView>(R.id.backEndPrice).text =
            "${storeItem.price} " + manageResources.string(R.string.amount_end)
        holder.itemView.findViewById<TextView>(R.id.backEndAmount).text = "${storeItem.amount}"
    }

    override fun getItemCount(): Int = items.size

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}