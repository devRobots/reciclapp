package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Venta(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var fecha: Date,
    var hora: String,
    var cantMaterial: Int,
    var precio: Long,
    var comprador: Comprador,
    var administrador: Administrador
)