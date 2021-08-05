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
class CP005InstrumentedTest {

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
    fun  validarEstadoCita(){
        db.collection("citas").get().addOnSuccessListener {
            val lista = ArrayList<Cita>()
            for (citas in it.documents){
                val retiro = citas.toObject(Cita::class.java)!!
                lista.add(retiro)
                assertNotNull(retiro.estado)
            }
            assertNotNull(lista)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

    @Test
    fun  validarFechaCita(){
        db.collection("citas").get().addOnSuccessListener {
            val lista = ArrayList<Cita>()
            for (citas in it.documents){
                val retiro = citas.toObject(Cita::class.java)!!
                lista.add(retiro)
                assertNotNull(retiro.fecha)
            }
            assertNotNull(lista)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

    @Test
    fun  verificarEstadoCitaAdmin(){
        val correo = "admin@reciclapp.com"
        val contrasenia = "reciclapp"

        auth.signInWithEmailAndPassword(correo,contrasenia).addOnSuccessListener {
            val usuario = it.user
            assertNotNull(usuario)
            db.collection("citas").get().addOnSuccessListener {
                val lista = ArrayList<Cita>()
                for (citas in it.documents){
                    val retiro = citas.toObject(Cita::class.java)!!
                    lista.add(retiro)
                    assertNotNull(retiro.estado)
                }
                assertNotNull(lista)
            }.addOnFailureListener{
                assertTrue(it.message, false)
            }
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

    @Test
    fun  verificarLoginAdministrador(){
        val correo = "admin@reciclapp.com"
        val contrasenia = "reciclapp"

        auth.signInWithEmailAndPassword(correo,contrasenia).addOnSuccessListener {
            val usuario = it.user
            assertNotNull(usuario)
            val persona = Persona.fromString(usuario!!.displayName)
            assertNotNull(persona)
            assertEquals(Rol.OPERADOR, persona!!.rol)
        }.addOnFailureListener{
            assertTrue(it.message, false)
        }
    }

}