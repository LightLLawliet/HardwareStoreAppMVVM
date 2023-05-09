package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.StoreApp
import com.example.hardwarestoreappmvvm.data.ManageResources

class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buyButton = view.findViewById<Button>(R.id.buyButton)
        val viewModel = (activity?.application as StoreApp).viewModel
        val adapter =
            StoreBackItemAdapter(ManageResources.Base(this.requireActivity()), viewModel, listOf())

        viewModel.getAllItems().observe(viewLifecycleOwner) {
            adapter.items = it
            adapter.notifyDataSetChanged()
        }
    }
}