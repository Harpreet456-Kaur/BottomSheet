package com.example.bottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import com.example.bottomsheet.databinding.ActivityMainBinding
import com.example.bottomsheet.databinding.BottomdialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChange.setOnClickListener {
            var dialog=BottomSheetDialog(this)
            var dialogBinding=BottomdialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.etName.setText(binding.tvThere.text.toString())
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etName.text.isEmpty()){
                    dialogBinding.etName.error="Enter your name"
                }
                else{
                    binding.tvThere.setText(dialogBinding.etName.text.toString())
                    dialog.dismiss()
                }
            }
            dialog.show()
            dialog.setCancelable(true)
        }
    }
}