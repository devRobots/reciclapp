package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.adapter.ListRetiroAdapter
import co.edu.uniquindio.reciclapp.model.Retiro
import java.util.*
import kotlin.collections.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {

    val elements = ArrayList<Retiro>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val listAdapter = ListRetiroAdapter(elements,context)

        val view = inflater.inflate(R.layout.fragment_registro, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rcvRetiroRealizado)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = listAdapter
        elements.add( Retiro( Date(),"12:00",45))
        elements.add( Retiro( Date(),"14:00",445))
        elements.add( Retiro( Date(),"13:00",3))
        return view
    }
}