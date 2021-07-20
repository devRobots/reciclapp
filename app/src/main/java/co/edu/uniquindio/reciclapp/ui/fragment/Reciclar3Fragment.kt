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
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [Reciclar3Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Reciclar3Fragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reciclar3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = Firebase.auth
        db = Firebase.firestore

        val user = auth.currentUser
        val persona = Persona.fromString(user?.displayName)

        val edtFecha = activity?.findViewById<EditText>(R.id.txtReciclar2FechaRecogida)
        val edtHora = activity?.findViewById<EditText>(R.id.txtReciclar2HoraRecogida)

        val lblUnidades = activity?.findViewById<TextView>(R.id.txtTransicion)
        val unidades = lblUnidades?.text.toString().split(",")
        val carton = unidades[0]
        val plastico = unidades[1]
        val vidrio = unidades[2]
        val unidad = unidades[3]
        val total = (carton.toInt() + plastico.toInt() + vidrio.toInt()).toString()

        val txtDireccion = view.findViewById<TextView>(R.id.txtReciclar3Direccion)
        val txtFecha = view.findViewById<TextView>(R.id.txtReciclar3Fecha)
        val txtHora = view.findViewById<TextView>(R.id.txtReciclar3Hora)

        val txtCarton = view.findViewById<TextView>(R.id.txtReciclar3Carton)
        val txtPlastico = view.findViewById<TextView>(R.id.txtReciclar3Plastico)
        val txtVidrio = view.findViewById<TextView>(R.id.txtReciclar3Vidrio)

        val txtUnidad1 = view.findViewById<TextView>(R.id.txtReciclar3Unidad1)
        val txtUnidad2 = view.findViewById<TextView>(R.id.txtReciclar3Unidad2)
        val txtUnidad3 = view.findViewById<TextView>(R.id.txtReciclar3Unidad3)

        val txtTotal = view.findViewById<TextView>(R.id.txtReciclar3TotalMateriales)

        txtDireccion.text = persona?.direccion
        txtFecha.text = edtFecha?.text.toString()
        txtHora.text = edtHora?.text.toString()
        txtCarton.text = carton
        txtPlastico.text = plastico
        txtVidrio.text = vidrio
        txtUnidad1.text = unidad
        txtUnidad2.text = unidad
        txtUnidad3.text = unidad
        txtTotal.text = total

        val btnContinuar = view.findViewById<Button>(R.id.btnReciclar3Confirmar)
        btnContinuar?.setOnClickListener {
            val fechaHora = txtFecha.text.toString() + " " + txtHora.text.toString()
            val fecha = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.US).parse(fechaHora)!!
            val cita = Cita(fecha, txtHora.text.toString(), EstadoCita.EN_PROCESO, -1.0,
                null, auth.currentUser!!.uid)

            db.collection("citas").add(cita).addOnSuccessListener {
                val tipoUnidad = if (unidad == "Unidades") TipoUnidad.UNIDADES else TipoUnidad.KILOGRAMOS
                val materialCarton = Material(TipoMaterial.CARTON_TETRAPACK, carton.toInt(), tipoUnidad, it.id, null)
                val materialPlastico = Material(TipoMaterial.PLASTICO_PETB, plastico.toInt(), tipoUnidad, it.id, null)
                val materialVidrio = Material(TipoMaterial.VIDRIO, vidrio.toInt(), tipoUnidad, it.id, null)

                db.collection("materiales").add(materialCarton)
                db.collection("materiales").add(materialPlastico)
                db.collection("materiales").add(materialVidrio)

                activity?.finish()
            }.addOnFailureListener {
                Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
            }

        }
    }
}