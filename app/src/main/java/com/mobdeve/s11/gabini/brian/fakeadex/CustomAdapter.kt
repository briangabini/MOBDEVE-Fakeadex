package com.mobdeve.s11.gabini.brian.fakeadex

import PokemonModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: ArrayList<PokemonModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val image: ImageView
        val name: TextView
        val type: TextView
        val location: TextView
        val desc: TextView
        val deleteButton: Button

        init {
            image = view.findViewById(R.id.pokemonImage)
            name = view.findViewById(R.id.name)
            type = view.findViewById(R.id.speciesInfo)
            location = view.findViewById(R.id.locationInfo)
            desc = view.findViewById(R.id.description)
            deleteButton = view.findViewById(R.id.deleteButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(dataSet[position].imageId)
        holder.name.text = dataSet[position].name
        holder.type.text = dataSet[position].specie
        holder.location.text = dataSet[position].location
        holder.desc.text = dataSet[position].desc

        holder.deleteButton.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataSet.size)
        }
    }
}