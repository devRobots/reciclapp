package co.edu.uniquindio.reciclapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class CitaRecolector (
    @Embedded val recolector: Recolector,
    @Relation(
        parentColumn = "id",
        entityColumn = "idRecolector"
    )
    var citas: List<Cita>
)