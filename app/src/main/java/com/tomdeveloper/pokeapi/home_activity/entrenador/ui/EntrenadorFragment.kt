package com.tomdeveloper.pokeapi.home_activity.entrenador.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.databinding.FragmentTrainerBinding
import com.tomdeveloper.pokeapi.home_activity.entrenador.vm.EntrenadorViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EntrenadorFragment : BaseFragment() {

    private val entrenadorViewModel: EntrenadorViewModel by viewModel()
    private lateinit var binding: FragmentTrainerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTrainerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textDashboard.text = "correcto !!!!!"
        entrenadorViewModel.pruebaGuardado()

    }
}