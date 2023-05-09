package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.StoreApp
import com.example.hardwarestoreappmvvm.data.ManageResources
import com.example.hardwarestoreappmvvm.data.cache.StoreCache

class AddFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = (activity?.application as StoreApp).viewModel
        val recyclerView = view.findViewById<RecyclerView>(R.id.storeItems)
        val adapter =
            StoreBackItemAdapter(
                ManageResources.Base(this.requireActivity()), viewModel,
                listOf()
            )
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }

        view.findViewById<ImageView>(R.id.addButton).setOnClickListener {
            StoreItemDialog(requireContext(),
                object : AddDialogListener {
                    override fun onClicked(cache: StoreCache) {
                        viewModel.insert(cache)
                    }
                }
            ).show()
        }
    }
}