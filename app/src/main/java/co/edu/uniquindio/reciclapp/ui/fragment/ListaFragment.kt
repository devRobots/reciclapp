package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.adapter.ListRetiroAdapter
import co.edu.uniquindio.reciclapp.model.Retiro
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [ListaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val elements = ArrayList<Retiro>()
        elements.add( Retiro( Date(),"12:00",45))
        elements.add( Retiro( Date(),"14:00",445))
        elements.add( Retiro( Date(),"13:00",3))
        recyclerView.adapter = ListRetiroAdapter(elements, activity)

    }

}