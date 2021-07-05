package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comprador(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var nit: String,
    var nombre: String,
    var telefono: Long,
    var correo: String
)