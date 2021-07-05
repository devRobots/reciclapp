package co.edu.uniquindio.reciclapp.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.data.Defaults
import co.edu.uniquindio.reciclapp.data.RoomApp
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var roomApp: RoomApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roomApp = RoomApp(this)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val dbReady = preferences.getBoolean("db_ready", false)
        if (!dbReady) {
            initDB()
        }

        checkSession()
    }

    private fun initDB() {
        val defaults = Defaults(this, roomApp)
        lifecycleScope.launch {
            defaults.init()
        }
    }

    private fun checkSession() {
        lifecycleScope.launch {
            val configs = roomApp.config.configDAO().obtenerConfiguraciones()[0]

            var intent: Intent? = null
            if (configs.usuario != null) {
                intent = Intent(this@MainActivity, HomeActivity::class.java)
            }
            else if (configs.usuario != null) {
                intent = Intent(this@MainActivity, AdminHomeActivity::class.java)
            }

            if (intent != null) {
                startActivity(intent)
                this@MainActivity.finish()
            }
        }
    }
}