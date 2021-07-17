package co.edu.uniquindio.reciclapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class VentaComprador(
    @Embedded val comprador: Comprador,
    @Relation(
        parentColumn = "id",
        entityColumn = "idComprador"
    )
    var ventas: List<Venta>
)
