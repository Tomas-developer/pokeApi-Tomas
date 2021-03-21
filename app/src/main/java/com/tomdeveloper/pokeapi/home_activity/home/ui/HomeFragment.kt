package com.tomdeveloper.pokeapi.home_activity.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.databinding.FragmentHomeBinding
import com.tomdeveloper.pokeapi.home_activity.home.mv.HomeViewModel
import com.tomdeveloper.pokeapi.utils.SharedPokemonVm
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment(), OnItemPokemonClickListener {

    private val homeViewModel: HomeViewModel by viewModel()
    private val sharedPokemonDTO: SharedPokemonVm by sharedViewModel()
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

            var adapter = PokemonDtoAdapter(it, this)
            if(it.isNotEmpty()){
                binding.recyclerHomeFragment.layoutManager = LinearLayoutManager(activity)
                binding.recyclerHomeFragment.adapter = adapter
            }

        })
        homeViewModel.getPokemon()

    }

    override fun onItemPokemonClicked(pokemonDTO: PokemonDTO) {
        sharedPokemonDTO.setPokemon(pokemonDTO)
        findNavController().navigate(R.id.action_navigation_home_to_detailsFragment)
    }
}