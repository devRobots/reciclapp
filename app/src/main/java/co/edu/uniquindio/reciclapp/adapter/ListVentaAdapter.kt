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
import co.edu.uniquindio.reciclapp.model.Venta

class ListVentaAdapter(var itemList: List<Venta>, context: Context?, val listener: View.OnClickListener) : RecyclerView.Adapter<ListVentaAdapter.ViewHolder>(){
    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.list_venta_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(itemList[position])
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Cambiar por lo que tiene un comprador
        private var precio: TextView = itemView.findViewById(R.id.txtListVentaPrecio)
        private var nombre: TextView = itemView.findViewById(R.id.txtListVentaComprador)
        private var fecha: TextView = itemView.findViewById(R.id.txtListVentaFecha)

        fun binData(item: Venta) {
            precio.text = item.precio.toString()
            nombre.text = "empresa"
            fecha.text = item.fecha.toString()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}
