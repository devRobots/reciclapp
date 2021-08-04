package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.adapter.ListCitaAdapter
import co.edu.uniquindio.reciclapp.adapter.ListRetiroAdapter
import co.edu.uniquindio.reciclapp.adapter.ListVentaAdapter
import co.edu.uniquindio.reciclapp.model.*
import com.getbase.floatingactionbutton.FloatingActionsMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [ListaVentaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaVentaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var txtUid: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        progressBar = view.findViewById(R.id.loaderLista)
        txtUid = view.findViewById(R.id.uidTransicion)
        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Ocultar Boton Flotante
        val fab: FloatingActionsMenu? = activity?.findViewById(R.id.fabMenuAdmin)
        fab?.visibility = View.GONE

        auth = Firebase.auth
        db = Firebase.firestore

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)


        db.collection("ventas").get().addOnSuccessListener {
                val lista = ArrayList<Venta>()
                for (document in it) {
                    lista.add(document.toObject(Venta::class.java))
                }

                recyclerView.adapter = ListVentaAdapter(lista, activity){}

                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }

    }
}