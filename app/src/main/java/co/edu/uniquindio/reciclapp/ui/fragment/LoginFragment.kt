package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import co.edu.uniquindio.reciclapp.R
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
                    Toast.makeText(this@LoginFragment.activity, user.uid, Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this@LoginFragment.activity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}