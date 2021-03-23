package com.tomdeveloper.pokeapi.home_activity.pokemon.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.commons.uicomponents.ErrorDialog
import com.tomdeveloper.pokeapi.databinding.FragmentHomeBinding
import com.tomdeveloper.pokeapi.home_activity.pokemon.mv.PokemonViewModel
import com.tomdeveloper.pokeapi.utils.SharedPokemonVm
import com.tomdeveloper.pokeapi.utils.positionRecycler
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class PokemonFragment : BaseFragment(), OnItemPokemonClickListener{

    private val pokemonViewModel: PokemonViewModel by viewModel()
    private val sharedPokemonDTO: SharedPokemonVm by sharedViewModel()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var linearLayoutManager: LinearLayoutManager

    private val limit = 20
    private var offset = 0

    private var adapter:PokemonDtoAdapter? = null

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
        loadObeservers()
        pokemonViewModel.getPokemon(offset, limit)
        linearLayoutManager = LinearLayoutManager(activity)
        binding.recyclerHomeFragment.layoutManager = linearLayoutManager
        binding.recyclerHomeFragment.scrollToPosition(positionRecycler)
        // OBTIENE MAS POKEMON CUANDO DETECTA QUE EL SCROLL HA LLEGADO AL FINAL
        binding.recyclerHomeFragment.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                positionRecycler = linearLayoutManager.findFirstVisibleItemPosition()
                if (!recyclerView.canScrollVertically(1)) {
                    pokemonViewModel.getPokemon(offset, limit)
                }
            }
        })

    }

    private fun loadObeservers() {
        pokemonViewModel.pokemonList.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                adapter = PokemonDtoAdapter(it, this)
                binding.recyclerHomeFragment.adapter = adapter
                nextStep()
                binding.recyclerHomeFragment.scrollToPosition(positionRecycler)
            }
        })


        /* MUESTRA DIALOGO DE ERROR EN CASO DE FALLO DE CARGA CON EL SERVIDOR, AL DARLE AL BOTON
        *  RECARGAR LANZARA OTRA PETICION
        */
        pokemonViewModel.showNetworkError.observe(viewLifecycleOwner, {
            if (it) {
                errorDialog = activity?.let { activity ->
                    ErrorDialog(
                            activity,
                            "Error en la red",
                            "Ha ocurrido un error con la red, comprueba que tienes disponible" +
                                    " la red móvil o el wifi y inténtalo de nuevo",
                            View.OnClickListener {
                                pokemonViewModel.showNetworkError.value = false
                                pokemonViewModel.getPokemon(offset, limit)
                            }
                    )
                }
                errorDialog!!.setCancelable(false)
                errorDialog!!.show()
            } else {
                errorDialog?.dismiss()
            }
        })
    }

    /* NAVEGA HASTA OTRO FRAGMENT CON MAS DETALLES DEL POKEMON Y COMPARTE CON DICHO FRAGMENT EL OBJETO
    * POKEMONDTO */
    override fun onItemPokemonClicked(pokemonDTO: PokemonDTO) {
        sharedPokemonDTO.setPokemon(pokemonDTO)
        findNavController().navigate(R.id.action_navigation_home_to_detailsFragment)
    }


    // metodo para cargar los siguientes pokemon
    fun nextStep(){
        offset += limit
    }

}
