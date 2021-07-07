package co.edu.uniquindio.reciclapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.Comprador
import co.edu.uniquindio.reciclapp.model.Recolector

class ListCitaAdapter(var itemList: List<Cita>, context: Context?, val listener: View.OnClickListener) : RecyclerView.Adapter<ListCitaAdapter.ViewHolder>(){
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.list_cita_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(itemList[position])
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Cambiar por lo que tiene una cita
        private var estado: TextView = itemView.findViewById(R.id.txtListCitaEstado)
        private var usuario: TextView = itemView.findViewById(R.id.txtListCitaUsuario)
        private var fecha: TextView = itemView.findViewById(R.id.txtListCitaFecha)
        private var hora: TextView = itemView.findViewById(R.id.txtListCitaHora)

        fun binData(item: Cita) {
            estado.text = item.estado.toString()
            usuario.text = item.usuario.nombre.toString()
            fecha.text = item.fecha.toString()
            hora.text = item.hora.toString()
            itemView.setOnClickListener(listener)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}
