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
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Persona
import co.edu.uniquindio.reciclapp.model.Rol
import co.edu.uniquindio.reciclapp.ui.activity.AdminHomeActivity
import co.edu.uniquindio.reciclapp.ui.activity.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = Firebase.auth

        val edtCedula = view.findViewById<EditText>(R.id.edtLoginCorreo)
        val edtContrasenia = view.findViewById<EditText>(R.id.edtLoginContrasenia)

        val btnIngresar = view.findViewById<Button>(R.id.btnLoginIngresar)
        btnIngresar?.setOnClickListener {
            val correo = edtCedula.text.toString()
            val contrasenia = edtContrasenia.text.toString()

            if (correo.isNotEmpty() && contrasenia.isNotEmpty()) {
                auth.signInWithEmailAndPassword(correo, contrasenia).addOnSuccessListener {
                    val user = it.user!!
                    val persona = Persona.fromString(user.displayName)
                    val intent = if (persona?.rol == Rol.OPERADOR) {
                        Intent(this@LoginFragment.requireContext(), AdminHomeActivity::class.java)
                    } else {
                        Intent(this@LoginFragment.requireContext(), HomeActivity::class.java)
                    }
                    startActivity(intent)
                    this@LoginFragment.requireActivity().finish()
                }.addOnFailureListener {
                    Toast.makeText(this@LoginFragment.activity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}