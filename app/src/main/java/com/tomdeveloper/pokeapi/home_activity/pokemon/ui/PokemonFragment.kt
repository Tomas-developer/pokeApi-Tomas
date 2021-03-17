package com.tomdeveloper.pokeapi.home_activity.pokemon.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.home_activity.pokemon.vm.PokemonViewModel

class PokemonFragment : Fragment() {

    private lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pokemonViewModel =
            ViewModelProvider(this).get(PokemonViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        return root
    }
}