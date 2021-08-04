package co.edu.uniquindio.reciclapp.ui.activity

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import co.edu.uniquindio.reciclapp.R
import co.edu.uniquindio.reciclapp.ui.fragment.RecolectorFragment
import com.getbase.floatingactionbutton.FloatingActionButton
import com.getbase.floatingactionbutton.FloatingActionsMenu
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AdminHomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        val fabMenuAdmin: FloatingActionsMenu = findViewById(R.id.fabMenuAdmin)
        val fabRecolector: FloatingActionButton = findViewById(R.id.fabRecolector)
        val fabComprador: FloatingActionButton = findViewById(R.id.fabComprador)
        val fabVenta: FloatingActionButton = findViewById(R.id.fabVentas)

        auth = Firebase.auth

        val toolbar: Toolbar = findViewById(R.id.admin_toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.admin_drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_admin_view)
        val navController = findNavController(R.id.nav_host_admin_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home_admin, R.id.nav_slideshow, R.id.listaRecolectorFragment2,
                R.id.listaCompradorFragment, R.id.estadisticasFragment,
                R.id.listaCitaFragment, R.id.rutasFragment), drawerLayout
        )
        navView.menu.findItem(R.id.logout).setOnMenuItemClickListener {
            auth.signOut()

            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            this@AdminHomeActivity.finish()
            true
        }
        //Fab Recolector
        fabRecolector.setOnClickListener{
            navController.navigate(R.id.nav_recolector)
            fabMenuAdmin.collapse()
            fabMenuAdmin.visibility = View.GONE
        }
        //Fab Comprador
        fabComprador.setOnClickListener {
            navController.navigate(R.id.nav_comprador)
            fabMenuAdmin.collapse()
            fabMenuAdmin.visibility = View.GONE
        }
        //Fab Venta
        fabVenta.setOnClickListener {
            navController.navigate(R.id.ventasFragment)
            fabMenuAdmin.collapse()
            fabMenuAdmin.visibility = View.GONE
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