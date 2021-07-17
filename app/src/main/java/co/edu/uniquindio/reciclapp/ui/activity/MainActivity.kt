package co.edu.uniquindio.reciclapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.data.local.misc.Defaults
import co.edu.uniquindio.reciclapp.data.local.RoomApp
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var roomApp: RoomApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomApp = RoomApp(this)

        lifecycleScope.launch {
            val default = Defaults(this@MainActivity, roomApp)
            default.init()
            checkSession()
        }
    }

    private suspend fun checkSession() {
        val configs = roomApp.config.configDAO().obtenerConfiguraciones()

        var intent: Intent? = null
        if (configs.idUsuario != null) {
            intent = Intent(this@MainActivity, HomeActivity::class.java)
        }
        else if (configs.idAdministrador != null) {
            intent = Intent(this@MainActivity, AdminHomeActivity::class.java)
        }

        if (intent != null) {
            startActivity(intent)
            this@MainActivity.finish()
        }
    }
}