package co.edu.uniquindio.reciclapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Retiro

class ListRetiroAdapter(var itemList: List<Retiro>, context: Context?) : RecyclerView.Adapter<ListRetiroAdapter.ViewHolder>() {
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.list_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(itemList[position])

        holder.itemView.setOnClickListener {

        }
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var fecha: TextView = itemView.findViewById(R.id.txtListFecha)
        private var hora: TextView = itemView.findViewById(R.id.txtListElementHora)
        private var material: TextView = itemView.findViewById(R.id.txtListElementTotal)

        fun binData(item: Retiro) {
            fecha.text = item.fecha.toString()
            hora.text = item.hora
            material.text = item.totalMaterial.toString()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}