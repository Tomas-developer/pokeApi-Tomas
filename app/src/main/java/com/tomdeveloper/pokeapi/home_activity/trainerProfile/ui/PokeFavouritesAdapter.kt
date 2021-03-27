package com.tomdeveloper.pokeapi.home_activity.trainerProfile.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomdeveloper.data.models.PokemonDTO
import com.tomdeveloper.pokeapi.R
import de.hdodenhof.circleimageview.CircleImageView

// adaptador para mostrar pokemons favoritos en el recycler
class PokeFavouritesAdapter(private var list: MutableList<PokemonDTO>,
                            private var context: Context,
                            private var onItemTouch: OnItemTouch): RecyclerView.Adapter<PokeFavouritesAdapter.MyView>() {


    inner class MyView(itemView: View):RecyclerView.ViewHolder(itemView) {
        var img = itemView.findViewById<CircleImageView>(R.id.img_pokemon)
        var btndelete = itemView.findViewById<ImageButton>(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_list_favourite, parent, false)
        return  MyView(v)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        Glide.with(context)
                .load(list[position].urlImage+".png")
                .error(R.drawable.ico_no_photo)
                .into(holder.img)
        holder.btndelete.setOnClickListener {
            onItemTouch.itemTouched(list[position])
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface OnItemTouch{
    fun itemTouched(pokemonDTO: PokemonDTO)
}