package com.example.examenhugo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TasquesAdapter(
    private var tasques: List<Tasca>
) : RecyclerView.Adapter<TasquesAdapter.TasquesViewHolder>() {

    // viewHolder
    inner class TasquesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nomTextView: TextView = itemView.findViewById(R.id.tvNom)
        private val categoriaTextView: TextView = itemView.findViewById(R.id.tvCategoria)
        private val dataTextView: TextView = itemView.findViewById(R.id.tvData)
        private val estatTextView: TextView = itemView.findViewById(R.id.tvEstat)

        // Función para "pintar" los datos de una canción en las vistas.
        fun renderitza(tasca: Tasca) {
            nomTextView.text = tasca.nom
            dataTextView.text = tasca.data
            // ACABAR
            //categoriaTextView.text = tasca.categoria
            // estatTextView.text = tasca.estat

            // Añadimos un listener para cuando se haga clic en una fila.
            itemView.setOnClickListener {
                Toast.makeText(
                    itemView.context,
                    "Has seleccionado: ${tasca.nom}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    //Fin viewHolder

    override fun getItemCount(): Int {
        return tasques.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasquesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tasca, parent, false)
        return TasquesViewHolder(view)
    }




    override fun onBindViewHolder(holder: TasquesViewHolder, position: Int) {
        val song = tasques[position]
        holder.renderitza(song)
    }

    fun setTasques(novesTasques: List<Tasca>) {
        tasques = novesTasques
        notifyDataSetChanged()
    }
}
// Holder per a Tascaa
class TascaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}