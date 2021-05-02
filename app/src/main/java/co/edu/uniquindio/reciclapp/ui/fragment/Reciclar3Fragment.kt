package co.edu.uniquindio.reciclapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.ui.activity.HomeActivity

/**
 * A simple [Fragment] subclass.
 * Use the [Reciclar3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Reciclar3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reciclar3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnContinuar = view.findViewById<Button>(R.id.btnReciclar3Confirmar)
        btnContinuar?.setOnClickListener {
            activity?.finish()
        }
    }
}