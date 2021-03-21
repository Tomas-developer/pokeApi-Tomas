package com.tomdeveloper.pokeapi.home_activity.details.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.databinding.FragmentDetailsBinding
import com.tomdeveloper.pokeapi.home_activity.details.vm.DetailsViewModel
import com.tomdeveloper.pokeapi.utils.SharedPokemonVm
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment() {

    private val sharedPokemonDTO: SharedPokemonVm by sharedViewModel()
    private val detailsViewModel: DetailsViewModel by viewModel()

    lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsViewModel.getPokemonFindId(sharedPokemonDTO.pokemon.value!!.id.toString())
        Glide.with(view.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+sharedPokemonDTO.pokemon.value!!.id+".png")
                .thumbnail(Glide.with(this).load(R.drawable.loading))
                .into(binding.detailsPokeImg)
        Log.e("url", Constants.URL_IMG_MAX_CUALITY+sharedPokemonDTO.pokemon.value!!.id+".svg")

        detailsViewModel.pokemon.observe(viewLifecycleOwner, {
            binding.detailsPokemonAltura.text = it.height?: "n/a"
            binding.detailsPokemonWidth.text = it.weight?.toString()?: "n/a"
            binding.detailsPokemonName.text = it.name?: "n/a"
        })


    }

}