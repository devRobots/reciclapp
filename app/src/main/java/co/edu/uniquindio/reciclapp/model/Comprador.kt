package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.uniquindio.reciclapp.data.ObjetoBase

@Entity
data class Comprador(
    @PrimaryKey(autoGenerate = true)
    override var id: Long,
    var nit: String,
    var nombre: String,
    var telefono: Long,
    var correo: String
) : ObjetoBase(id, "compradores")