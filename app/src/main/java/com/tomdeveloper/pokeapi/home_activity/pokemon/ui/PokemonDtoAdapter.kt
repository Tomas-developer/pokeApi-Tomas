package com.tomdeveloper.pokeapi.home_activity.pokemon.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.pokeapi.R

class PokemonDtoAdapter(private val lista: MutableList<PokemonDTO>,
                        private val itemPokemonClickListener: OnItemPokemonClickListener): RecyclerView.Adapter<PokemonDtoAdapter.MiViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val a = LayoutInflater.from(parent.context).inflate(R.layout.item_list_pokemon, parent, false)
        return MiViewHolder(a)
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.pokeName.text = lista[position].name
        Glide.with(holder.itemView.context)
            .load(lista[position].urlImage)
            .thumbnail(Glide.with(holder.itemView.context).load(R.drawable.loading))
            .error(R.drawable.ico_no_photo)
            .into(holder.pokePhoto)
        holder.itemView.setOnClickListener {
                itemPokemonClickListener.onItemPokemonClicked(lista[position])
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    class MiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokeName = itemView.findViewById<TextView>(R.id.item_poke_name)
        val pokePhoto = itemView.findViewById<ImageView>(R.id.item_poke_img)
    }

}

interface OnItemPokemonClickListener {
    fun onItemPokemonClicked(pokemonDTO: PokemonDTO)
}