package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Venta
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

        var edtPrecio = view.findViewById<EditText>(R.id.edtPrecioVenta)

        val uidOperador: String
        val btnGuardar = view.findViewById<Button>(R.id.btnVentaGuardar)
        btnGuardar?.setOnClickListener {
            val fecha = Date()
            val hora = Date().toString()
            val precio = edtPrecio.text.toString().toLong()
            val venta = Venta(fecha,hora,precio,null,null)

            db.collection("ventas").add(venta)
            val intent = Intent(this@VentaFragment.requireContext(), HomeAdminFragment::class.java)
            startActivity(intent)
            this@VentaFragment.activity?.finish()
        }
    }
}