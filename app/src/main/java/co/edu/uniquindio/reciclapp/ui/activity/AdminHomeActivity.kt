package co.edu.uniquindio.reciclapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.data.Config
import co.edu.uniquindio.reciclapp.data.RoomApp
import kotlinx.coroutines.launch

class AdminHomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var roomApp: RoomApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        roomApp = RoomApp(this)

        val toolbar: Toolbar = findViewById(R.id.admin_toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.admin_drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_admin_view)
        val navController = findNavController(R.id.nav_host_admin_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home_admin, R.id.nav_slideshow, R.id.listaRecolectorFragment2,
                R.id.listaCompradorFragment, R.id.ventasFragment, R.id.estadisticasFragment,
                R.id.citasFragment, R.id.rutasFragment), drawerLayout
        )
        navView.menu.findItem(R.id.logout).setOnMenuItemClickListener {
            lifecycleScope.launch {
                roomApp.config.configDAO().actualizar(Config(1))
            }

            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            this@AdminHomeActivity.finish()
            true
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.admin_home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_admin_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}