package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Ciudadano
import co.edu.uniquindio.reciclapp.model.TipoDocumento
import co.edu.uniquindio.reciclapp.ui.activity.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class RegistroFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var spinner: Spinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_registro, container, false)

        spinner = view.findViewById(R.id.spnRegistroTipoPersona)
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

        val txtNombre = view.findViewById<EditText>(R.id.edtRegistroNombre)
        val txtApellido = view.findViewById<EditText>(R.id.edtRegistroApellido)
        val txtNumDocumeto = view.findViewById<EditText>(R.id.edtRegistroNumDoc)
        val txtCorreo = view.findViewById<EditText>(R.id.edtRegistroCorreo)
        val txtContrasenia = view.findViewById<EditText>(R.id.edtRegistroContrasenia)
        val txtDireccion = view.findViewById<EditText>(R.id.edtRegistroDireccion)

        val btnRegistro = view.findViewById<Button>(R.id.btnRegistrarRegistro)
        btnRegistro.setOnClickListener {
            val nombre = txtNombre.text.toString().trim()
            val apellido = txtApellido.text.toString().trim()
            val tipoPersona = spinner.selectedItem as String
            val numeroDocumento = txtNumDocumeto.text.toString().trim()
            val direccion = txtDireccion.text.toString().trim()

            val correo = txtCorreo.text.toString().trim()
            val contrasenia = txtContrasenia.text.toString().trim()

            if (correo.isNotEmpty() && contrasenia.isNotEmpty()) {
                val tipoDocumento = if (tipoPersona == TipoDocumento.CEDULA.persona) TipoDocumento.CEDULA else TipoDocumento.NIT
                val ciudadano = Ciudadano(nombre, apellido, tipoDocumento, numeroDocumento, null, correo, direccion)

                auth.createUserWithEmailAndPassword(correo, contrasenia).addOnSuccessListener {
                    val usuario = it.user!!
                    val infoUsuario = UserProfileChangeRequest.Builder()
                        .setDisplayName(ciudadano.toString()).build()
                    usuario.updateProfile(infoUsuario)
                    db.collection("ciudadanos").document(usuario.uid).set(ciudadano)

                    val intent = Intent(this@RegistroFragment.requireContext(), HomeActivity::class.java)
                    startActivity(intent)
                    this@RegistroFragment.activity?.finish()
                }.addOnFailureListener {
                    Toast.makeText(this@RegistroFragment.activity, it.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}