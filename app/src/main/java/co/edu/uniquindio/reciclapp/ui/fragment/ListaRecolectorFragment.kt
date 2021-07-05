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
import co.edu.uniquindio.reciclapp.adapter.ListRecolectorAdapter
import co.edu.uniquindio.reciclapp.model.Recolector
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [ListaRecolectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaRecolectorFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val elements = ArrayList<Recolector>()
        elements.add( Recolector(1, "Camilo Quiceno", 3196681290, "ccquicenol@uqvirtual.edu.co" ))
        elements.add( Recolector(2,"Samara Rincon", 3392039, "ssrinconm@uqvirtual.edu.co"))
        elements.add( Recolector(3, "Yesid Rosas", 31392193, "ysrosast@uqvirtual.edu.co"))
        recyclerView.adapter = ListRecolectorAdapter(elements, activity) {
            findNavController().navigate(R.id.nav_recolector)
        }
    }
}