package co.edu.uniquindio.reciclapp

import android.content.Context
import android.content.Intent
import co.edu.uniquindio.reciclapp.model.Persona
import co.edu.uniquindio.reciclapp.ui.activity.MainActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.junit.Assert.*
import org.mockito.runners.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {
    @Mock
    private lateinit var mockContext: Context

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun verificarLoginCiudadano(){
        mockContext = MainActivity()
        val firebaseOption = FirebaseOptions.Builder()
            .setApiKey("AIzaSyDn1WgIKi_K6lOnB4ax7x8sbjksfKXOERU")//
            .setApplicationId("1:1000509682036:android:a4f0942da16b5ac33d3c21")//
            .setProjectId("reciclapp-uq")//
            .build()
        val firebaseApp = FirebaseApp.initializeApp(mockContext,firebaseOption)
        val db = FirebaseFirestore.getInstance(firebaseApp)
        assertNotNull(db)
    }
}