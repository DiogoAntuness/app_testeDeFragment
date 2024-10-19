package com.example.treinofragment.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.treinofragment.Animais
import com.example.treinofragment.R

import com.example.treinofragment.fragments.placeholder.PlaceholderContent.PlaceholderItem
import com.example.treinofragment.databinding.FragmentSegundBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<Animais>//Passo minha lista da data class
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(binding: FragmentSegundBinding) : RecyclerView.ViewHolder(binding.root) {
        val nome: TextView = binding.nomeAnimal
        val tipo: TextView = binding.tipoAnimal
        val idade: TextView = binding.idadeAnimal
        //TUDO OK
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Mantive do jeito que estava.
        return ViewHolder(
            FragmentSegundBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nome.text = item.animail
        holder.tipo.text = item.tipo
        holder.idade.text = "Idade:  ${item.idade}"
        //Troquei as parada, criei +1 no xml e add aqui
    }

    override fun getItemCount(): Int = values.size //Massa!

}