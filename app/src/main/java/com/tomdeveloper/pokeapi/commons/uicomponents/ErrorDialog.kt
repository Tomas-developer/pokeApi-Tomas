package com.tomdeveloper.pokeapi.commons.uicomponents

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.tomdeveloper.pokeapi.databinding.ErrorDialogBinding

class ErrorDialog(context: Context, var title: String, var message: String, var listener: View.OnClickListener?): Dialog(context) {

    private lateinit var binding: ErrorDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ErrorDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.errorDialogBtn.setOnClickListener(listener)
        binding.errorDialogMessage.text = message
        binding.errorDialogTitle.text = title



    }

    override fun show() {
        super.show()
        val window = window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }



}