package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.adapter.ListCitaAdapter
import co.edu.uniquindio.reciclapp.adapter.ListCompradorAdapter
import co.edu.uniquindio.reciclapp.data.RoomApp
import co.edu.uniquindio.reciclapp.model.*
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [ListaCitaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaCitaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var roomApp : RoomApp

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

        roomApp = RoomApp(requireContext())

        lifecycleScope.launch {
            val elements = roomApp.admin.citaDAO().obtenerTodas()
            recyclerView.adapter = ListCitaAdapter(elements, activity) {
                findNavController().navigate(R.id.citasFragment)
            }
        }
    }
}