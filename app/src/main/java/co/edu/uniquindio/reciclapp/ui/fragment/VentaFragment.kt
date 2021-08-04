package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Venta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [VentaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VentaFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_venta, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = Firebase.auth
        db = Firebase.firestore

        var edtPrecio = view.findViewById<EditText>(R.id.edtPrecioVenta)

        val uidOperador: String
        val btnGuardar = view.findViewById<Button>(R.id.btnVentaGuardar)
        btnGuardar?.setOnClickListener {
            val fecha = Date()
            val hora = Date().toString()
            val precio = edtPrecio.text.toString().toLong()
            val venta = Venta(fecha,hora,precio,null,null)

            db.collection("ventas").add(venta).addOnSuccessListener {
                findNavController().navigate(R.id.nav_home_admin)
            }.addOnFailureListener {
                Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}