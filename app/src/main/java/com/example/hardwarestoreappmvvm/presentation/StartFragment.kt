package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hardwarestoreappmvvm.R
import com.google.android.material.button.MaterialButton

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBackEnd = view.findViewById<MaterialButton>(R.id.backEndButton)
        val buttonStoreFront = view.findViewById<MaterialButton>(R.id.storeFrontButton)
        buttonBackEnd.setOnClickListener {
            NavigationStrategy.Add(AddFragment())
                .navigate(parentFragmentManager, R.id.container)
        }
        buttonStoreFront.setOnClickListener {
            NavigationStrategy.Add(BuyFragment())
                .navigate(parentFragmentManager, R.id.container)
        }
    }
}