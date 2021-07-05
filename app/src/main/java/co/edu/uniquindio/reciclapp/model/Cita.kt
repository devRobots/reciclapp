package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Cita(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var fecha: Date,
    var hora: String,
    var estado: EstadoCita,
    var calificacion: Double,
    var recolector: Recolector,
    var usuario: Usuario
)