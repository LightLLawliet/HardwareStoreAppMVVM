package com.example.hardwarestoreappmvvm.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.hardwarestoreappmvvm.data.cache.StoreCache
import com.example.hardwarestoreappmvvm.databinding.DialogItemBinding

class StoreItemDialog(
    context: Context,
    private val addDialogListener: AddDialogListener
) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DialogItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val amount = binding.editTextAmount.text.toString()
            val price = binding.editTextPrice.text.toString()

            if (name.isEmpty() || amount.isEmpty() || price.isEmpty()) {
                Toast.makeText(context, "Please enter all data", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = StoreCache(name, amount.toInt(), price.toInt())
            addDialogListener.onClicked(item)
            dismiss()
        }
        binding.textViewCancel.setOnClickListener {
            cancel()
        }
    }
}