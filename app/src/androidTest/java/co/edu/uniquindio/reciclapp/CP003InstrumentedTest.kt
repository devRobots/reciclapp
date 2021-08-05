package co.edu.uniquindio.reciclapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.Context
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.Persona
import co.edu.uniquindio.reciclapp.model.Recolector
import co.edu.uniquindio.reciclapp.model.Rol
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import java.util.ArrayList

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CP003InstrumentedTest {

    private lateinit var appContext: Context
    private lateinit var firebaseApp: FirebaseApp
    private lateinit var db : FirebaseFirestore
    private lateinit var auth : FirebaseAuth

    @Before
    fun initBD(){
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        firebaseApp = FirebaseApp.initializeApp(appContext)!!
        db = FirebaseFirestore.getInstance(firebaseApp)
        auth = FirebaseAuth.getInstance(firebaseApp)
    }

    @Test
    fun useAppContext() {
        assertEquals("co.edu.uniquindio.reciclapp", appContext.packageName)
    }

    @Test
    fun  validarRecolectores(){
        db.collection("recolectores").get().addOnSuccessListener {
            val lista = ArrayList<Recolector>()
            for (doc in it.documents){
                val recolector = doc.toObject(Recolector::class.java)!!
                lista.add(recolector)
                assertNotNull(recolector)
            }
            assertNotNull(lista)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

    @Test
    fun  listarRecolectores(){
        var cont = 0
        db.collection("recolectores").get().addOnSuccessListener {
            val lista = ArrayList<Recolector>()
            for (doc in it.documents){
                val recolector = doc.toObject(Recolector::class.java)!!
                lista.add(recolector)
                assertNotNull(recolector)
                cont++
            }
            assertEquals(cont,lista.size)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

}