package co.edu.uniquindio.reciclapp.data.local.misc

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Config(
    @PrimaryKey
    val id: Int = 1,
    var idUsuario: Long?,
    var idAdministrador: Long?
) {
    constructor(id: Int) : this(id, null, null)
}