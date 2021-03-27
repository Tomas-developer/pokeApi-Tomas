package com.tomdeveloper.pokeapi.home_activity.details.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomdeveloper.data.commons.Constants
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.commons.uicomponents.ErrorDialog
import com.tomdeveloper.pokeapi.databinding.FragmentDetailsBinding
import com.tomdeveloper.pokeapi.home_activity.details.vm.DetailsViewModel
import com.tomdeveloper.pokeapi.utils.SharedPokemonVm
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment(), CompoundButton.OnCheckedChangeListener {

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

        // obtiene el pokemon de la api remota
        detailsViewModel.getPokemonFindId(sharedPokemonDTO.pokemon.value!!.id.toString())

        // listener para detectar el checkbox
        binding.buttonAddFavourite.setOnCheckedChangeListener(this)
        Glide.with(view.context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"+sharedPokemonDTO.pokemon.value!!.id+".png")
                .thumbnail(Glide.with(this).load(R.drawable.loading))
                .error(R.drawable.ico_no_photo)
                .into(binding.detailsPokeImg)
        loadObservers()

    }

    // carga os observers
    private fun loadObservers() {
        detailsViewModel.pokemon.observe(viewLifecycleOwner, {
            binding.detailsPokemonAltura.text = it.height?: "n/a"
            binding.detailsPokemonWidth.text = it.weight?.toString()?: "n/a"
            binding.detailsPokemonName.text = it.name
            if(it.favourite){
                // le pongo el listener a null por que sino salta y me guarda, o salta el toast
                binding.buttonAddFavourite.setOnCheckedChangeListener(null)
                binding.buttonAddFavourite.isChecked = it.favourite
                // vuelvo a activarle el listener
                binding.buttonAddFavourite.setOnCheckedChangeListener(this)
            }
            it.types?.let {
                var adapter = PokemonTypeAdapter(it, requireContext())
                var layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding.detailTypeList?.layoutManager = layoutManager
                binding.detailTypeList?.adapter = adapter
            }
        })

        // muestra dialogo de error en caso de que falle la carga
        detailsViewModel.showNetworkError.observe(viewLifecycleOwner, Observer {
            if(it){
                errorDialog = activity?.let { activity ->
                    ErrorDialog(
                            activity,
                            "Error en la red",
                            "Ha ocurrido un error con la red, comprueba que tienes disponible" +
                                    " la red móvil o el wifi y inténtalo de nuevo"
                    ) {
                        detailsViewModel.showNetworkError.value = false
                        detailsViewModel.getPokemonFindId(sharedPokemonDTO.pokemon.value!!.id.toString())
                    }
                }
                errorDialog!!.setCancelable(false)
                errorDialog!!.show()
            }else{
                errorDialog?.dismiss()
            }
        })
    }

    override fun onCheckedChanged(p0: CompoundButton?, ischecked: Boolean) {
        when(p0){
            binding.buttonAddFavourite -> {
                // al darle al checkbox borra o anade el pokemon de la bd local
                if(ischecked){
                    detailsViewModel.saveFavouritePokemonToLocalDatabase()
                    Toast.makeText(context, "Pokemon guardado en favoritos", Toast.LENGTH_LONG).show()
                }else{
                    detailsViewModel.deleteFavouritePokemonToLocalDatabase()
                    Toast.makeText(context, "Pokemon eliminado de favoritos", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}