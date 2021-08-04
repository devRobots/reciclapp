package co.edu.uniquindio.reciclapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import co.edu.uniquindio.reciclapp.model.Persona
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import android.content.Context
import android.content.Intent
import android.util.Log
import co.edu.uniquindio.reciclapp.ui.activity.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

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
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("co.edu.uniquindio.reciclapp", appContext.packageName)
    }

    @Test
    fun  verificarLoginCiudadano(){
        val correo = "ccquicenol@uqvirtual.edu.co"
        val contrasenia = "123456"

        auth.signInWithEmailAndPassword(correo,contrasenia).addOnSuccessListener {
            assertNotNull(it.user)
            db.collection("ciudadanos").document(it.user!!.uid).get().addOnSuccessListener {
                doc ->
                assertEquals(1,2)
            }.addOnFailureListener{
                assertEquals(1,2)
            }
        }.addOnFailureListener{
            assertEquals(1,2)
        }
    }

}