package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.ui.dialog.SelectorFechaDialog
import co.edu.uniquindio.reciclapp.ui.dialog.SelectorHoraDialog
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [Reciclar2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Reciclar2Fragment : Fragment() {
    lateinit var txtFechaRecogida: EditText
    lateinit var txtHoraRecogida: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reciclar2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val carton = activity?.findViewById<EditText>(R.id.txtReciclar1UnidadCarton)?.text.toString()
        val plastico = activity?.findViewById<EditText>(R.id.txtReciclar1UnidadPlastico)?.text.toString()
        val vidrio = activity?.findViewById<EditText>(R.id.txtReciclar1UnidadVidrio)?.text.toString()
        val unidad = activity?.findViewById<TextView>(R.id.lblUnidad1)?.text.toString()

        val txtTransicion = view.findViewById<TextView>(R.id.txtTransicion)
        txtTransicion.text = "$carton,$plastico,$vidrio,$unidad"

        txtFechaRecogida = view.findViewById(R.id.txtReciclar2FechaRecogida)
        txtFechaRecogida.setOnClickListener {
            val newFragment = SelectorFechaDialog.newInstance { _, year, month, day ->
                val selectedDate = "$year/${factorizarData(month + 1)}/${factorizarData(day)}"
                txtFechaRecogida.setText(selectedDate)
            }
            newFragment.show(childFragmentManager, "datePicker")
        }

        txtHoraRecogida = view.findViewById(R.id.txtReciclar2HoraRecogida)
        txtHoraRecogida.setOnClickListener {
            val newFragment = SelectorHoraDialog.newInstance { _, hour, minute ->
                val selectedHour = "${factorizarData(hour)}:${factorizarData(minute)}"
                txtHoraRecogida.setText(selectedHour)
            }
            newFragment.show(childFragmentManager, "timePicker")
        }

        val btnSiguiente = view.findViewById<Button>(R.id.btnReciclar2Siguiente)
        btnSiguiente.setOnClickListener {
            val fecha = txtFechaRecogida.text.toString()
            val hora = txtHoraRecogida.text.toString()

            if (fecha.isNotEmpty() && hora.isNotEmpty()) {
                if (validarFechaHora(fecha, hora)) {
                    findNavController().navigate(R.id.reciclar3Fragment)
                } else {
                    Toast.makeText(context, "La fecha y hora ingresadas no son validas", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Llene los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun factorizarData(value: Int) : String = if (value < 10) "0$value" else "$value"

    fun validarFechaHora(fecha: String, hora: String): Boolean {
        val fechaActual = Date()
        val fechaIngresada = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US).parse("$fecha $hora")!!
        return fechaIngresada >= fechaActual
    }
}