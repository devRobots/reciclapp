package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Administrador(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,
    cedula: Int,
    nombre: String,
    apellido: String,
    telefono: Long,
    direccion: String,
    correo: String,
    contrasenia: String
) : Usuario(id, cedula, nombre, apellido, telefono, direccion, correo, contrasenia)