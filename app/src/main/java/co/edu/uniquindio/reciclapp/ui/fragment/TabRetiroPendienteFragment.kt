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
import co.edu.uniquindio.reciclapp.adapter.ListRetiroAdapter
import co.edu.uniquindio.reciclapp.data.local.RoomApp
import kotlinx.coroutines.launch
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [TabRetiroPendienteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabRetiroPendienteFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var roomApp: RoomApp

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

        roomApp = RoomApp(requireContext())

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        lifecycleScope.launch {
            val usuario = roomApp.config.configDAO().obtenerConfiguraciones().idUsuario
            val elements = roomApp.local.citaDAO().obtenerPendientesPorUsuario(usuario!!)
            recyclerView.adapter = ListRetiroAdapter(elements, activity){
                findNavController().navigate(R.id.citasFragment)
            }
        }
    }

}