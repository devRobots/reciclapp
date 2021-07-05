package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
open class Usuario(
    @PrimaryKey(autoGenerate = true)
    open val id: Int,
    val cedula: Int,
    var nombre: String,
    var apellido: String,
    var telefono: Long,
    var direccion: String,
    var correo: String,
    var contrasenia: String
)