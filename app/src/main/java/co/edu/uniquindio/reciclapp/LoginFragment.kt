package co.edu.uniquindio.reciclapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnIngresar = view.findViewById<Button>(R.id.btnLoginIngresar)
        btnIngresar?.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

}