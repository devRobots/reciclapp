package co.edu.uniquindio.reciclapp.model

import androidx.room.Embedded
import androidx.room.Relation

data class MaterialVenta(
    @Embedded val venta: Venta,
    @Relation(
        parentColumn = "id",
        entityColumn = "idVenta"
    )
    val materiales: List<Material>
)
