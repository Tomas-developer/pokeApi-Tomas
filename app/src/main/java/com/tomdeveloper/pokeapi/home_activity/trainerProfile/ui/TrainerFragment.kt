package com.tomdeveloper.pokeapi.home_activity.trainerProfile.ui

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.circularreveal.CircularRevealHelper
import com.tomdeveloper.data.models.ProfileDto
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.commons.BaseFragment
import com.tomdeveloper.pokeapi.databinding.FragmentTrainerBinding
import com.tomdeveloper.pokeapi.home_activity.trainerProfile.vm.EntrenadorViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
import java.security.Key
import java.security.Signature
import java.util.*

class TrainerFragment : BaseFragment(), View.OnClickListener {

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
    }

    // cargar listeners
    private fun loadListeners(){
        binding.btnEditTrainerfragment.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_entrenador_to_takePhotoProfileFragment)
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
                    if(!binding.textAgeTrainerfragment.text.toString().isNullOrEmpty())
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
}