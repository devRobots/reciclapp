package co.edu.uniquindio.reciclapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class AccesoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acceso, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnAccesoIngresar = view.findViewById<Button>(R.id.btnAccesoIngresar)
        btnAccesoIngresar.setOnClickListener{ findNavController().navigate(R.id.loginFragment) }

        val btnAccesoRegistrar = view.findViewById<Button>(R.id.btnAccesoRegistrar)
        btnAccesoRegistrar.setOnClickListener{ findNavController().navigate(R.id.registroFragment) }

        val btnAccesoQuienesSomos = view.findViewById<Button>(R.id.btnAccesoQuienesSomos)
        btnAccesoQuienesSomos.setOnClickListener{ findNavController().navigate(R.id.reciclar2Fragment) }
    }

}