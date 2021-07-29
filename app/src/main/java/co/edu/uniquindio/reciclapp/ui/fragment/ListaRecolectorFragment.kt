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
import co.edu.uniquindio.reciclapp.adapter.ListRecolectorAdapter
import co.edu.uniquindio.reciclapp.adapter.ListRetiroAdapter
import co.edu.uniquindio.reciclapp.model.Recolector
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [ListaRecolectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaRecolectorFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var txtUid: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        progressBar = view.findViewById(R.id.loaderLista)
        txtUid = view.findViewById(R.id.uidTransicion)
        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        auth = Firebase.auth
        db = Firebase.firestore

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        db.collection("recolectores")
            .get().addOnSuccessListener {
                val lista = ArrayList<Recolector>()
                for (document in it) {
                    lista.add(document.toObject(Recolector::class.java))
                }

                recyclerView.adapter = ListRecolectorAdapter(lista, activity){ view ->
                    val position = recyclerView.getChildLayoutPosition(view)
                    txtUid.text = it.documents[position].id
                    //Mira el folder de recolectores
                    //TODO: crear un folder para solo verlo (??
                    findNavController().navigate(R.id.nav_recolector)
                }

                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }


    }
}