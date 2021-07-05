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
import androidx.lifecycle.lifecycleScope
import co.edu.uniquindio.reciclapp.ui.activity.HomeActivity
import co.edu.uniquindio.reciclapp.ui.activity.AdminHomeActivity
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.data.RoomApp
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private lateinit var roomApp: RoomApp

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        roomApp  = RoomApp(requireActivity())

        val edtCedula = view.findViewById<EditText>(R.id.edtLoginCedula)
        val edtContrasenia = view.findViewById<EditText>(R.id.edtLoginContrasenia)

        val btnIngresar = view.findViewById<Button>(R.id.btnLoginIngresar)
        btnIngresar?.setOnClickListener {
            val cedula = edtCedula.text.toString()
            val contrasenia = edtContrasenia.text.toString()

            if (cedula.isNotEmpty() && contrasenia.isNotEmpty()) {
                esAdmin(cedula, contrasenia)
                esUser(cedula, contrasenia)
            }
        }
    }

    private fun esAdmin(cedula: String, contrasenia: String) {
        lifecycleScope.launch {
            val admin = roomApp.admin.administradorDAO().login(cedula.toInt(), contrasenia)
            if (admin != null) {
                val configs = roomApp.config.configDAO().obtenerConfiguraciones()[0]
                configs.administrador = admin
                roomApp.config.configDAO().actualizar(configs)

                val intent = Intent(context, AdminHomeActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }
    }

    private fun esUser(cedula: String, contrasenia: String) {
        lifecycleScope.launch {
            val usuario = roomApp.usuario.usuarioDAO().login(cedula.toInt(), contrasenia)
            if (usuario != null) {
                val configs = roomApp.config.configDAO().obtenerConfiguraciones()[0]
                configs.usuario = usuario
                roomApp.config.configDAO().actualizar(configs)

                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }
    }

}