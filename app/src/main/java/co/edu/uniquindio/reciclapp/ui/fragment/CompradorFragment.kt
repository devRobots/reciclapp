package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.data.RoomApp
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [CompradorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompradorFragment : Fragment() {
    private lateinit var roomApp: RoomApp

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comprador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        roomApp = RoomApp(requireContext())

        val edtNit = view.findViewById<EditText>(R.id.txtCompradorNIT)
        val edtNombre = view.findViewById<EditText>(R.id.txtCompradorNombre)
        val edtCelular = view.findViewById<EditText>(R.id.txtCompradorCelular)
        val edtCorreo = view.findViewById<EditText>(R.id.txtCompradorCorreo)

        lifecycleScope.launch {
            val comprador = roomApp.admin.compradorDAO().obtenerPorId(1)
            if (comprador != null) {
                edtNit?.setText(comprador.nit)
                edtNombre?.setText(comprador.nombre)
                edtCelular?.setText(comprador.telefono.toString())
                edtCorreo?.setText(comprador.correo)
            }
        }
    }
}