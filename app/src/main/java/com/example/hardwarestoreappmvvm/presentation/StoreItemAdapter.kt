package com.example.hardwarestoreappmvvm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.data.cache.StoreCache

class StoreItemAdapter(
    private val manageResources: ManageResources,
    var items: List<StoreCache>,
    private val viewModel: StoreViewModel
) : RecyclerView.Adapter<StoreItemAdapter.StoreViewHolder>() {

    private val list = mutableListOf<StoreUi>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.store_item, parent, false)
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        val storeItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.tvName).text = storeItem.name
        holder.itemView.findViewById<TextView>(R.id.tvPrice).text =
            "${storeItem.price} " + manageResources.string(R.string.amount_end)
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text = "${storeItem.amount}"

        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener {
            viewModel.delete(storeItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.ivPlus).setOnClickListener {
            storeItem.amount++
            viewModel.insert(storeItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.ivMinus).setOnClickListener {
            if (storeItem.amount > 0) {
                storeItem.amount--
                viewModel.insert(storeItem)
            }
        }
    }

    fun map(source: List<StoreUi>) {
        val diff = StoreCallback(list, source)
        val result = DiffUtil.calculateDiff(diff)
        list.clear()
        list.addAll(source)
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = items.size

    inner class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

class StoreCallback(
    private val oldList: List<StoreUi>,
    private val newList: List<StoreUi>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].map(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}