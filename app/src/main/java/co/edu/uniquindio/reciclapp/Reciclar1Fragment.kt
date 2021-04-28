package co.edu.uniquindio.reciclapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [Reciclar1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Reciclar1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reciclar1, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSiguiente = view.findViewById<Button>(R.id.btnReciclar1Siguiente)
        btnSiguiente.setOnClickListener { findNavController().navigate(R.id.reciclar2Fragment) }
    }
}