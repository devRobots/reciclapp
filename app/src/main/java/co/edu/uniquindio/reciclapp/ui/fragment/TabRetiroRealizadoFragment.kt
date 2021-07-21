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
import co.edu.uniquindio.reciclapp.adapter.ListRetiroAdapter
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.EstadoCita
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [TabRetiroRealizadoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabRetiroRealizadoFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var txtUid: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        progressBar = view.findViewById(R.id.loaderLista)
        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)
        txtUid = view.findViewById(R.id.uidTransicion)

        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        auth = Firebase.auth
        db = Firebase.firestore

        val user = auth.currentUser!!

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        db.collection("citas")
            .whereEqualTo("uidCiudadano", user.uid)
            .whereIn("estado", listOf(EstadoCita.COMPLETADO, EstadoCita.CANCELADO))
            .get().addOnSuccessListener {
                val lista = ArrayList<Cita>()
                for (document in it) {
                    lista.add(document.toObject(Cita::class.java))
                }

                recyclerView.adapter = ListRetiroAdapter(lista, activity){ view ->
                    val position = recyclerView.getChildLayoutPosition(view)
                    txtUid.text = it.documents[position].id
                    findNavController().navigate(R.id.retiroFragment)
                }

                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
    }


}