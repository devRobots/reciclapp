package co.edu.uniquindio.reciclapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import co.edu.uniquindio.reciclapp.R

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

        val edtCarton = view.findViewById<EditText>(R.id.txtReciclar1UnidadCarton)
        val edtPlastico = view.findViewById<EditText>(R.id.txtReciclar1UnidadPlastico)
        val edtVidrio = view.findViewById<EditText>(R.id.txtReciclar1UnidadVidrio)

        val dropdown = view.findViewById<AutoCompleteTextView>(R.id.dropdown_unidades)
        val lblUnidad1 = view.findViewById<TextView>(R.id.lblUnidad1)
        val lblUnidad2 = view.findViewById<TextView>(R.id.lblUnidad2)
        val lblUnidad3 = view.findViewById<TextView>(R.id.lblUnidad3)

        val unidades = resources.getStringArray(R.array.unidades)
        ArrayAdapter.createFromResource(requireContext(), R.array.unidades,
            android.R.layout.simple_spinner_item).also { adapter ->
            dropdown.setAdapter(adapter)
            dropdown.setOnItemClickListener { parent, view, position, id ->
                lblUnidad1.text = unidades[position]
                lblUnidad2.text = unidades[position]
                lblUnidad3.text = unidades[position]
            }
        }

        val btnSiguiente = view.findViewById<Button>(R.id.btnReciclar1Siguiente)
        btnSiguiente.setOnClickListener {
            edtCarton.setText(if (edtCarton.text.isEmpty()) "0" else edtCarton.text)
            edtPlastico.setText(if (edtPlastico.text.isEmpty()) "0" else edtPlastico.text)
            edtVidrio.setText(if (edtVidrio.text.isEmpty()) "0" else edtVidrio.text)

            val cantCarton = edtCarton.text.toString().toInt()
            val cantPlastico = edtPlastico.text.toString().toInt()
            val cantVidrio = edtVidrio.text.toString().toInt()

            val total = cantCarton + cantPlastico + cantVidrio

            if(total > 0) {
                findNavController().navigate(R.id.reciclar2Fragment)
            } else {
                Toast.makeText(context, "Ingrese por lo menos un material", Toast.LENGTH_SHORT).show()
            }
        }
    }
}