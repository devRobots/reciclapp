package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Material(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var tipo: TipoMaterial,
    var cantidad: Int,
    var cita: Cita?,
    var detalleVenta: DetalleVenta?
)