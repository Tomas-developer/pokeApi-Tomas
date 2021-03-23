package com.tomdeveloper.pokeapi.home_activity.details.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomdeveloper.data.models.Types
import com.tomdeveloper.pokeapi.R
import com.tomdeveloper.pokeapi.databinding.ItemListTypeBinding

// ADAPTADOR PARA CARGAR LOS TIPOS DE POKEMON
class PokemonTypeAdapter(private val list:List<Types>, val context: Context): RecyclerView.Adapter<PokemonTypeAdapter.MyView>() {

    private lateinit var binding: ItemListTypeBinding

    inner class MyView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameType = binding.itemListTypeText
        var photoType = binding.itemListTypePhoto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        binding = ItemListTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyView(binding.root)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: MyView, position: Int) {
        list?.let {
            /* SEGUN EL TIPO DE POKEMON LE PONGO LA IMAGEN DE TIPO CORRESPONDIENTE EJEMPLO: TIPO VOLADOR  */
            holder.nameType.text = list?.get(position).type.name
            when(list?.get(position).type.name){
                "normal"-> holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_normal))
                "fighting"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_fighting)) }
                "flying"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_flying)) }
                "poison"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_poison)) }
                "ground"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_ground)) }
                "rock"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_rock)) }
                "bug"->{ holder.photoType.setImageDrawable( context.getDrawable(R.drawable.ic_type_bug)) }
                "ghost"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_ghost)) }
                "steel"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_steel)) }
                "fire"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_fire)) }
                "water"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_water)) }
                "grass"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_grass)) }
                "electric"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_electric)) }
                "psychic"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_psychic)) }
                "ice"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_ice)) }
                "dragon"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_dragon)) }
                "dark"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_dark)) }
                "fairy"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_fairy)) }
                "unknown"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_unknown)) }
                "shadow"->{ holder.photoType.setImageDrawable(context.getDrawable(R.drawable.ic_type_ghost)) }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}