package com.tomdeveloper.pokeapi.home_activity.trainerProfile.ui

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.data.models.ProfileDto
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.databinding.FragmentTrainerBinding
import com.tomdeveloper.pokeapi.home_activity.HomeActivity
import com.tomdeveloper.pokeapi.home_activity.trainerProfile.vm.EntrenadorViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

class TrainerFragment : BaseFragment(), View.OnClickListener, OnItemTouch {

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
        getPhotoUserProfile()
        loadListeners()
        loadObservers()
        entrenadorViewModel.loadPokemonFavourites()
        entrenadorViewModel.loadProfile()
    }

    // cargo los observers
    private fun loadObservers(){
        entrenadorViewModel.profile.observe(viewLifecycleOwner, {
            it?.let {
                binding.textNameTrainerfragment.setText(it.name)
                it.surname?.let { binding.textSurnameTrainerfragment.setText(it)}
                it.numBadget?.let { binding.textNumbadgetTrainerfragment.setText(it.toString()) }
                it.age?.let { binding.textAgeTrainerfragment.setText(it.toString()) }
            }
        })

        entrenadorViewModel.pokemonFavourites.observe(viewLifecycleOwner, {
            it?.let {
                binding.recyclerTrainerfragment.adapter = PokeFavouritesAdapter(it.toMutableList(), requireContext(), this)
                binding.recyclerTrainerfragment.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL , false)
                if(it.isEmpty()){
                    binding.textNopokemonaddedTrainerfragment.visibility = View.VISIBLE
                    binding.recyclerTrainerfragment.visibility = View.GONE
                }else{
                    binding.textNopokemonaddedTrainerfragment.visibility = View.GONE
                    binding.recyclerTrainerfragment.visibility = View.VISIBLE
                }
            }

        })
    }

    // cargar listeners
    private fun loadListeners(){
        binding.btnEditTrainerfragment.setOnClickListener {
            /* si el permiso de la camara esta concedido le dejo al usuario navegar al fragment
            de la camara y si no le pido permisos
             */
            if(checkPermission()){
                findNavController().navigate(R.id.action_navigation_entrenador_to_takePhotoProfileFragment)
            }else{
                activity?.requestPermissions(HomeActivity.REQUIRED_PERMISSIONS, HomeActivity.REQUEST_CODE_PERMISSIONS)
            }

        }
        binding.btnSaveprofileTrainerfragment.setOnClickListener(this)
    }

    // obtiene foto del usuario, si no existe carga una por defecto
    private fun getPhotoUserProfile() {
        if (getOutputDirectory().listFiles().isNotEmpty()) {
            /* position (obtengo siempre la ultima foto de la lista que es la mas reciente),
            las demas fotos quedan guardadas en el directorio */
            var position = getOutputDirectory().listFiles().size - 1
            Glide.with(this)
                    .load(File(getOutputDirectory(), getOutputDirectory().listFiles()[position].name))
                    .error(R.drawable.photoprofiledefault)
                    .into(binding.profileImage)
        }
    }


    // obtiene el directorio de la app, si no existe lo crea
    private fun getOutputDirectory(): File {
        val mediaDir = requireActivity().externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else requireActivity().filesDir
    }

    override fun onClick(p0: View?) {
        when(p0){
            p0->{
                if(binding.textNameTrainerfragment.text.isNullOrEmpty()){
                    binding.textNameTrainerfragment.error = "El nombre es obligatorio."
                }else{
                    var age:Int? = null
                    var medals:Int? = null
                    if(!binding.textAgeTrainerfragment.text.toString().isNullOrEmpty())
                        age = binding.textAgeTrainerfragment.text.toString().toInt()
                    if(!binding.textNumbadgetTrainerfragment.text.toString().isNullOrEmpty())
                        medals = binding.textNumbadgetTrainerfragment.text.toString().toInt()
                    entrenadorViewModel.saveProfile(
                            ProfileDto(binding.textNameTrainerfragment.text.toString(),
                                    binding.textSurnameTrainerfragment.text?.toString(),
                                    age,
                                    medals
                            )
                    )
                    Toast.makeText(context, "Has guardado tú perfil.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun itemTouched(pokemonDTO: PokemonDTO) {
        Toast.makeText(context, "Has eliminado a ${pokemonDTO.name} de favoritos.", Toast.LENGTH_LONG).show()
        entrenadorViewModel.deletePokemonFavourite(pokemonDTO)
    }

    private fun checkPermission(): Boolean{
        return ContextCompat
                .checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }
}