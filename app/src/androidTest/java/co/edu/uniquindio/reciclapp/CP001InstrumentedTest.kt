package co.edu.uniquindio.reciclapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.content.Context
import co.edu.uniquindio.reciclapp.model.Persona
import co.edu.uniquindio.reciclapp.model.Rol
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CP001InstrumentedTest {

    private lateinit var appContext: Context
    private lateinit var firebaseApp: FirebaseApp
    private lateinit var auth : FirebaseAuth

    @Before
    fun initBD(){
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
        firebaseApp = FirebaseApp.initializeApp(appContext)!!
        auth = FirebaseAuth.getInstance(firebaseApp)
    }

    @Test
    fun useAppContext() {
        assertEquals("co.edu.uniquindio.reciclapp", appContext.packageName)
    }

    @Test
    fun  registrarCiudadano(){
        val correo = "ysrosast_1@uqvirtual.edu.co"
        val contrasenia = "123456"

        auth.createUserWithEmailAndPassword(correo, contrasenia).addOnSuccessListener {
            val usuario = it.user
            assertNotNull(usuario)
        }.addOnFailureListener{
            assertThrows(it.message, it.cause!!::class.java, null)
        }
    }

    @Test
    fun  verificarLoginCiudadano(){
        val correo = "ccquicenol@uqvirtual.edu.co"
        val contrasenia = "123456"

        auth.signInWithEmailAndPassword(correo,contrasenia).addOnSuccessListener {
            val usuario = it.user
            assertNotNull(usuario)
            val persona = Persona.fromString(usuario!!.displayName)
            assertNotNull(persona)
            assertEquals(Rol.CIUDADANO, persona!!.rol)
        }.addOnFailureListener{
            assertThrows(it.message, it.cause!!::class.java, null)
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
            assertThrows(it.message, it.cause!!::class.java, null)
        }
    }

}