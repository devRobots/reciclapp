package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.uniquindio.reciclapp.data.ObjetoBase

@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    override var id: Long,
    val cedula: Int,
    var nombre: String,
    var apellido: String,
    var telefono: Long,
    var direccion: String,
    var correo: String,
    var contrasenia: String
) : ObjetoBase(id, "usuarios")