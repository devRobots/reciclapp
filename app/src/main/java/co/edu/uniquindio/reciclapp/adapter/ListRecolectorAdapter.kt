package co.edu.uniquindio.reciclapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Recolector

class ListRecolectorAdapter(var itemList: List<Recolector>, context: Context?) : RecyclerView.Adapter<ListRecolectorAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.list_element, null)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(itemList[position])
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var id: TextView = itemView.findViewById(R.id.txtListRecolectorId)
        private var nombre: TextView = itemView.findViewById(R.id.txtListRecolectorNombre)
        private var telefono: TextView = itemView.findViewById(R.id.txtListRecolectorTelefono)
        private var correo: TextView = itemView.findViewById(R.id.txtListRecolectorCorreo)

        fun binData(item: Recolector) {
            id.text = item.idRecolector.toString()
            nombre.text = item.nombre
            telefono.text = item.telefono.toString()
            correo.text = item.correo

        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}