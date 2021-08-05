package co.edu.uniquindio.reciclapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.Context
import co.edu.uniquindio.reciclapp.model.*
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
class CP004InstrumentedTest {

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
    fun  listarComprador(){
        db.collection("compradores").get().addOnSuccessListener {
            var cont = 0
            val lista = ArrayList<Comprador>()
            for (comp in it.documents){
                val comprador = comp.toObject(Comprador::class.java)!!
                lista.add(comprador)
                cont++
            }
            assertEquals(cont,lista.size)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

    fun  leerDatosComprador(){
        db.collection("compradores").get().addOnSuccessListener {
            val lista = ArrayList<Comprador>()
            for (comp in it.documents){
                val comprador = comp.toObject(Comprador::class.java)!!
                assertNotNull(comprador.nombre)
                assertNotNull(comprador.numeroDocumento)
            }
            assertNotNull(lista)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }


}