package co.edu.uniquindio.reciclapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class CitaUsuario (
    @Embedded val usuaro: Usuario,
    @Relation(
        parentColumn = "id",
        entityColumn = "idUsuario"
    )
    var citas: List<Cita>
)