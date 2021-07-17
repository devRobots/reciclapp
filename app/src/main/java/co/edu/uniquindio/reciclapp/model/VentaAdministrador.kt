package co.edu.uniquindio.reciclapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class VentaAdministrador(
    @Embedded val administrador: Administrador,
    @Relation(
        parentColumn = "id",
        entityColumn = "idAdministrador"
    )
    var ventas: List<Venta>
)
