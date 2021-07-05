package co.edu.uniquindio.reciclapp.data

import androidx.room.Entity
import co.edu.uniquindio.reciclapp.model.Usuario
import java.util.*

@Entity
data class Config(
    val id: Int = 1,
    var usuario: Usuario?,
    var ultimaVez: Date
)