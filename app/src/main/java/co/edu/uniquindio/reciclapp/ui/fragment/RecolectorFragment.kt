package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Recolector
import co.edu.uniquindio.reciclapp.model.TipoDocumento
import co.edu.uniquindio.reciclapp.ui.activity.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 * Use the [RecolectorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecolectorFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recolector, container, false)

        spinner = view.findViewById(R.id.spnRecolectorTipoPersona)
        ArrayAdapter.createFromResource(requireContext(), R.array.tipo_personas,
            android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = Firebase.auth
        db = Firebase.firestore

        //valores de los campos a ingresar al DB
        val txtNombre = view.findViewById<EditText>(R.id.txtRecolectorNombre)
        val txtApellido = view.findViewById<EditText>(R.id.txtRecolectorApellido)
        val txtNumDocumeto = view.findViewById<EditText>(R.id.txtRecolectoCedula)
        val txtCelular = view.findViewById<EditText>(R.id.txtRecolectorCelular)
        val txtCorreo = view.findViewById<EditText>(R.id.txtRecolectorCorreo)
        val txtDireccion = view.findViewById<EditText>(R.id.txtRecolectorDireccion)

        val btnGuardar = view.findViewById<Button>(R.id.btnRecolectorGuardar)
        btnGuardar?.setOnClickListener {
            val nombre = txtNombre.text.toString().trim()
            val apellido = txtApellido.text.toString().trim()
            val numDocumento = txtNumDocumeto.text.toString().trim()
            val celular = txtCelular.text.toString().trim()
            val correo = txtCorreo.text.toString().trim()
            val direccion =  txtDireccion.text.toString().trim()
            val tipoPersona = spinner.selectedItem as String

            if (correo.isNotEmpty() && numDocumento.isNotEmpty()){
                val tipoDocumento = if (tipoPersona == TipoDocumento.CEDULA.persona) TipoDocumento.CEDULA else TipoDocumento.NIT
                val recolector = Recolector(nombre,apellido,tipoDocumento,numDocumento,celular,correo,direccion)
                db.collection("recolectores").add(recolector)

                val intent = Intent(this@RecolectorFragment.requireContext(), HomeAdminFragment::class.java)
                startActivity(intent)
                this@RecolectorFragment.activity?.finish()
            }
        }
    }

}