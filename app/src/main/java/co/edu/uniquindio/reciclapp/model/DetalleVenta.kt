package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DetalleVenta (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var precioUnidad: Double,
    var venta: Venta,
    var material:Material
)