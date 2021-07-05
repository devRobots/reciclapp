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
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.EstadoCita
import co.edu.uniquindio.reciclapp.model.Recolector
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
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        val elements = ArrayList<Cita>()
        // TODO: Persistir
        // elements.add( Cita( 1, Date(),"12:00", EstadoCita.EN_PROCESO,4.5, null, null))
        // elements.add( Cita( 2, Date(),"14:00", EstadoCita.EN_PROCESO,4.5, null, null))
        // elements.add( Cita( 3, Date(),"13:00", EstadoCita.EN_PROCESO,3.0, null, null))
        recyclerView.adapter = ListRetiroAdapter(elements, activity)
    }

}