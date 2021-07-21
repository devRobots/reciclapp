package co.edu.uniquindio.reciclapp.ui.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.EstadoCita
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 * Use the [RetiroFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RetiroFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_retiro, container, false)

        auth = Firebase.auth
        db = Firebase.firestore

        val edtFecha = view.findViewById<TextInputEditText>(R.id.edtRetiroFecha)
        val edtHora = view.findViewById<TextInputEditText>(R.id.edtRetiroHora)
        val txtEstado = view.findViewById<TextView>(R.id.txtRetiroEstado)
        val cardEstado = view.findViewById<CardView>(R.id.cardRetiroEstado)

        val uidText = activity?.findViewById<TextView>(R.id.uidTransicion)
        db.collection("citas").document(uidText?.text.toString())
            .get().addOnSuccessListener {
                val retiro = it.toObject(Cita::class.java)
                edtFecha.setText(retiro?.fecha.toString())
                edtHora.setText(retiro?.hora.toString())
                txtEstado.text = retiro?.estado.toString()

                cardEstado.setCardBackgroundColor(when(retiro?.estado) {
                    EstadoCita.EN_PROCESO -> Color.GRAY
                    EstadoCita.APLAZADO -> Color.YELLOW
                    EstadoCita.CANCELADO -> Color.RED
                    EstadoCita.ACEPTADO, EstadoCita.COMPLETADO -> Color.GREEN
                    else -> Color.WHITE
                })
            }

        return view
    }
}