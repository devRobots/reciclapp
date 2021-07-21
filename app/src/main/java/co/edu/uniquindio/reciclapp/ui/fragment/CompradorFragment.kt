package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Comprador

/**
 * A simple [Fragment] subclass.
 * Use the [CompradorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CompradorFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_comprador, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtNit = view.findViewById<EditText>(R.id.txtCompradorNIT)
        val edtNombre = view.findViewById<EditText>(R.id.txtCompradorNombre)
        val edtCelular = view.findViewById<EditText>(R.id.txtCompradorCelular)
        val edtCorreo = view.findViewById<EditText>(R.id.txtCompradorCorreo)

        val comprador: Comprador? = null
        if (comprador != null) {
            edtNit?.setText(comprador.numeroDocumento)
            edtNombre?.setText(comprador.nombre)
            edtCelular?.setText(comprador.telefono.toString())
            edtCorreo?.setText(comprador.correo)
        }
    }
}