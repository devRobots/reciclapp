package co.edu.uniquindio.reciclapp.ui.fragment

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.ui.dialog.SelectorFechaDialog
import co.edu.uniquindio.reciclapp.ui.dialog.SelectorHoraDialog

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

        txtFechaRecogida = view.findViewById(R.id.txtReciclar2FechaRecogida)
        txtFechaRecogida.setOnClickListener {
            val newFragment = SelectorFechaDialog.newInstance(DatePickerDialog.OnDateSetListener { _, year, month, day ->
                val selectedDate = "$year/${(month+1)}/$day"
                txtFechaRecogida.setText(selectedDate)
            })
            newFragment.show(childFragmentManager, "datePicker")
        }

        txtHoraRecogida = view.findViewById(R.id.txtReciclar2HoraRecogida)
        txtHoraRecogida.setOnClickListener {
            val newFragment = SelectorHoraDialog.newInstance(TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val selectedHour = "$hour:$minute"
                txtHoraRecogida.setText(selectedHour)
            })
            newFragment.show(childFragmentManager, "timePicker")
        }
    }
}