package co.edu.uniquindio.reciclapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.model.Persona
import co.edu.uniquindio.reciclapp.model.Rol
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth
        if (auth.currentUser != null) {
            val persona = Persona.fromString(auth.currentUser?.displayName)
            val intent = if (persona?.rol == Rol.OPERADOR) {
                Intent(baseContext, AdminHomeActivity::class.java)
            } else {
                Intent(baseContext, HomeActivity::class.java)
            }
            startActivity(intent)
            this.finish()
        }

        setContentView(R.layout.activity_main)
    }
}