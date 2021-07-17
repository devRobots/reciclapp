package co.edu.uniquindio.reciclapp.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
open class ObjetoBase (
    @Ignore
    @PrimaryKey(autoGenerate = true)
    open var id: Long,
    @Ignore var coleccion: String
)