package co.edu.uniquindio.reciclapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class MaterialCita(
    @Embedded val cita: Cita,
    @Relation(
        parentColumn = "id",
        entityColumn = "idCita"
    )
    val materiales: List<Material>
)
