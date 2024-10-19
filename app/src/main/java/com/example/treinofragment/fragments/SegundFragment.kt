package com.example.treinofragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.treinofragment.Animais
import com.example.treinofragment.R
import com.example.treinofragment.fragments.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class SegundFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_segund_list, container, false)

        val lista = listOf(
                Animais("Cachorro", "Mamifero", 5),
                Animais("Gato", "Mamifero", 3),
                Animais("Vaca", "Mamifero", 7),
                Animais("Galinha", "Ave", 2),
                Animais("Cobra", "Réptil", 4)
        )
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)//Exibe os itens em uma única coluna (ou linha, se fosse horizontal).
                    else -> GridLayoutManager(context, columnCount)
                //Exibe os itens em um layout de grade, com múltiplas colunas.
                // O número de colunas é determinado pelo valor de columnCount.
                }
                adapter = MyItemRecyclerViewAdapter( lista )
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SegundFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}