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
import co.edu.uniquindio.reciclapp.model.Comprador
import co.edu.uniquindio.reciclapp.model.Recolector

class ListCompradorAdapter(var itemList: List<Comprador>, context: Context?, val listener: View.OnClickListener) : RecyclerView.Adapter<ListCompradorAdapter.ViewHolder>(){
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.list_comprador_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(itemList[position])
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Cambiar por lo que tiene un comprador
        private var nit: TextView = itemView.findViewById(R.id.txtListCompradorNit)
        private var nombre: TextView = itemView.findViewById(R.id.txtListCompradorNombre)
        private var telefono: TextView = itemView.findViewById(R.id.txtListCompradorTelefono)

        fun binData(item: Comprador) {
            nit.text = item.nit
            nombre.text = item.nombre
            telefono.text = item.telefono.toString()
            itemView.setOnClickListener(listener)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}
