package co.edu.uniquindio.reciclapp.ui.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.*

class SelectorHoraDialog : DialogFragment() {

    private var listener: TimePickerDialog.OnTimeSetListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return TimePickerDialog(requireContext(), listener, 12, 0, false)
    }

    companion object {
        fun newInstance(listener: TimePickerDialog.OnTimeSetListener): SelectorHoraDialog {
            val fragment = SelectorHoraDialog()
            fragment.listener = listener
            return fragment
        }
    }

}