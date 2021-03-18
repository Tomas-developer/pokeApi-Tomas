package com.tomdeveloper.pokeapi.home_activity.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.databinding.FragmentHomeBinding
import com.tomdeveloper.pokeapi.home_activity.home.mv.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.pokemonList.observe(viewLifecycleOwner, {
            var adapter = PokemonDtoAdapter(it as MutableList<PokemonDTO>)
            binding.recyclerHomeFragment.layoutManager = LinearLayoutManager(activity)
            binding.recyclerHomeFragment.adapter = adapter
        })

        homeViewModel.getPokemon()
        /*
        homeViewModel.getPokemon()?.let {
            var adapter = PokemonDtoAdapter(it)
            binding.recyclerHomeFragment.layoutManager = LinearLayoutManager(activity)
            binding.recyclerHomeFragment.adapter = adapter
        }
         */

    }
}