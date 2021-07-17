package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import co.edu.uniquindio.reciclapp.data.ObjetoBase
import java.util.*

@Entity
data class Cita(
    @PrimaryKey(autoGenerate = true)
    override var id: Long,
    var fecha: Date,
    var hora: String,
    var estado: EstadoCita,
    var calificacion: Double,
    var idRecolector: Long,
    var idUsuario: Long
) : ObjetoBase(id, "citas")