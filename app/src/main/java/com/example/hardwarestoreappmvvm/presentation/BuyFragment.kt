package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.data.ManageResources
import com.example.hardwarestoreappmvvm.data.Repository
import com.example.hardwarestoreappmvvm.data.cache.StoreDatabase

class BuyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val database = StoreDatabase(requireActivity())
        val repository = Repository(database)
        val factory = ViewModelFactory(repository, DispatchersList.Base())
        val viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        val recyclerView = view.findViewById<RecyclerView>(R.id.frontItems)
        val adapter =
            StoreFrontItemAdapter(ManageResources.Base(this.requireActivity()), listOf())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }
}