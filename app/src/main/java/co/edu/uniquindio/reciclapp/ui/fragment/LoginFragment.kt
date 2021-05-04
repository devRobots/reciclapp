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
import co.edu.uniquindio.reciclapp.ui.activity.HomeActivity
import co.edu.uniquindio.reciclapp.ui.activity.AdminHomeActivity
import co.edu.uniquindio.reciclapp.R

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val edtCedula = view.findViewById<EditText>(R.id.edtLoginCedula)
        val edtContrasenia = view.findViewById<EditText>(R.id.edtLoginContrasenia)

        val btnIngresar = view.findViewById<Button>(R.id.btnLoginIngresar)
        btnIngresar?.setOnClickListener {
            val cedula = edtCedula.text.toString()
            val contrasenia = edtContrasenia.text.toString()

            if (cedula.isNotEmpty() && contrasenia.isNotEmpty()) {
                when {
                    esAdmin(cedula, contrasenia) -> {
                        val intent = Intent(context, AdminHomeActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                    esUser(cedula, contrasenia) -> {
                        val intent = Intent(context, HomeActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                    else -> {
                        Toast.makeText(context, R.string.fragment_login_cuenta_desconocida, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun esAdmin(cedula: String, contrasenia: String): Boolean {
        if (cedula == "123" && contrasenia == "root") {
            return true
        }
        return false
    }

    private fun esUser(cedula: String, contrasenia: String): Boolean {
        if (cedula == "456789" && contrasenia == "root") {
            return true
        }
        return false
    }

}