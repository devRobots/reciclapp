package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.adapter.ListCompradorAdapter
import co.edu.uniquindio.reciclapp.model.Comprador
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [ListaCompradorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaCompradorFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista, container, false)
        //Lista generica
        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val elements = ArrayList<Comprador>()
        elements.add( Comprador(1, "179537","Cristian Quiceno",3196681290,"ccquicenol@uqvirtual.edu.co"))
        elements.add( Comprador(2, "179538","Joshua Quiceno",31543384895,"jjoshua@uqvirtual.edu.co"))
        recyclerView.adapter = ListCompradorAdapter(elements, activity) {
            findNavController().navigate(R.id.nav_comprador)
        }
    }
}