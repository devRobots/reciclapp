package co.edu.uniquindio.reciclapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Cita

class ListRetiroAdapter(var itemList: List<Cita>, context: Context?, val listener: View.OnClickListener) : RecyclerView.Adapter<ListRetiroAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.list_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(itemList[position])
        holder.itemView.setOnClickListener(listener)
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var estado: TextView = itemView.findViewById(R.id.txtListEstado)
        private var fecha: TextView = itemView.findViewById(R.id.txtListFecha)
        private var hora: TextView = itemView.findViewById(R.id.txtListElementHora)
        private var material: TextView = itemView.findViewById(R.id.txtListElementTotal)

        fun binData(item: Cita) {
            estado.text = item.estado.toString()
            fecha.text = item.fecha.toString()
            hora.text = item.hora
            material.text = "3" // TODO: item.totalMaterial.toString()
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}