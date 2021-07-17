package co.edu.uniquindio.reciclapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import co.edu.uniquindio.reciclapp.data.ObjetoBase

@Entity
data class Material(
    @PrimaryKey(autoGenerate = true)
    override var id: Long,
    var tipo: TipoMaterial,
    var cantidad: Int,
    var idCita: Long?,
    var idVenta: Long?
) : ObjetoBase(id, "materiales")