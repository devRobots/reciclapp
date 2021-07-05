package co.edu.uniquindio.reciclapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.uniquindio.reciclapp.model.Administrador
import co.edu.uniquindio.reciclapp.model.Usuario
import java.util.*

@Entity
data class Config(
    @PrimaryKey
    val id: Int = 1,
    var usuario: Usuario?,
    var administrador: Administrador?
)