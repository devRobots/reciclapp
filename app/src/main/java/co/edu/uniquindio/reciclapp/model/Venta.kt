package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.uniquindio.reciclapp.data.ObjetoBase
import java.util.*

@Entity
class Venta(
    @PrimaryKey(autoGenerate = true)
    override var id: Long,
    var fecha: Date,
    var hora: String,
    var cantMaterial: Int,
    var precio: Long,
    var idComprador: Long,
    var idAdministrador: Long
) : ObjetoBase(id, "ventas")