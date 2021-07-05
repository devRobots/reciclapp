package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cedula: Int,
    var nombre: String,
    var apellido: String,
    var telefono: Long,
    var direccion: String,
    var correo: String,
    var contrasenia: String
)