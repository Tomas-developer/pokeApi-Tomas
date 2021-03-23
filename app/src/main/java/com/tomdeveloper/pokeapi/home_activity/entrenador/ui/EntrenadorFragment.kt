package com.tomdeveloper.pokeapi.home_activity.entrenador.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.home_activity.entrenador.vm.EntrenadorViewModel

class EntrenadorFragment : BaseFragment() {

    private lateinit var entrenadorViewModel: EntrenadorViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        entrenadorViewModel =
            ViewModelProvider(this).get(EntrenadorViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_trainer, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        return root
    }
}