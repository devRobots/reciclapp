package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Comprador
import co.edu.uniquindio.reciclapp.model.TipoDocumento
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 * Use the [CompradorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompradorFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_comprador, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtNit = view.findViewById<EditText>(R.id.txtCompradorNIT)
        val edtNombre = view.findViewById<EditText>(R.id.txtCompradorNombre)
        val edtCelular = view.findViewById<EditText>(R.id.txtCompradorCelular)
        val edtCorreo = view.findViewById<EditText>(R.id.txtCompradorCorreo)
        val edtDireccion = view.findViewById<EditText>(R.id.txtCompradorDireccion)

        val btnGuardar = view.findViewById<Button>(R.id.btnCompradorGuardar)
        btnGuardar?.setOnClickListener {
            val nombre = edtNombre.text.toString().trim()
            val nit = edtNit.text.toString().trim()
            val celular = edtCelular.text.toString().trim()
            val correo = edtCorreo.text.toString().trim()
            val direccion =  edtDireccion.text.toString().trim()

            val comprador = Comprador(nombre,null,TipoDocumento.NIT,nit,celular,correo,direccion)
            db.collection("compradores").add(comprador)

            val intent = Intent(this@CompradorFragment.requireContext(), HomeAdminFragment::class.java)
            startActivity(intent)
            this@CompradorFragment.activity?.finish()
        }
    }
}