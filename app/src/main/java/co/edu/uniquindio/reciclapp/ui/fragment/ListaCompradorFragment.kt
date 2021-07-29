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
import co.edu.uniquindio.reciclapp.adapter.ListCompradorAdapter
import co.edu.uniquindio.reciclapp.model.Comprador
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [ListaCompradorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaCompradorFragment : Fragment() {

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
        recyclerView = view.findViewById(R.id.rcvRetiroRealizado)
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

        db.collection("compradores")
            .get().addOnSuccessListener {
                val lista = ArrayList<Comprador>()
                for (document in it) {
                    lista.add(document.toObject(Comprador::class.java))
                }

                recyclerView.adapter = ListCompradorAdapter(lista, activity){ view ->
                    val position = recyclerView.getChildLayoutPosition(view)
                    txtUid.text = it.documents[position].id
                    //Mira el folder de Comprador
                    //TODO: crear un folder para solo verlo (??
                    findNavController().navigate(R.id.nav_comprador)
                }

                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }
    }
}