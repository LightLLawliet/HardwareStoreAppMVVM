package com.example.hardwarestoreappmvvm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.data.ManageResources
import com.example.hardwarestoreappmvvm.data.cache.StoreCache

class StoreBackItemAdapter(
    private val manageResources: ManageResources,
    var items: List<StoreCache>,
    private val viewModel: MainViewModel
) : RecyclerView.Adapter<StoreBackItemAdapter.StoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_back_item, parent, false)
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val storeItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.backEndName).text = storeItem.name
        holder.itemView.findViewById<TextView>(R.id.backEndPrice).text =
            "${storeItem.price} " + manageResources.string(R.string.amount_end)
        holder.itemView.findViewById<TextView>(R.id.backEndAmount).text = "${storeItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.imageViewDelete).setOnClickListener {
            viewModel.delete(storeItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.imageViewPlus).setOnClickListener {
            storeItem.amount++
            viewModel.insert(storeItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.imageViewMinus).setOnClickListener {
            if (storeItem.amount > 0) {
                storeItem.amount--
                viewModel.insert(storeItem)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}