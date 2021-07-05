package co.edu.uniquindio.reciclapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.edu.uniquindio.reciclapp.data.Converters
import co.edu.uniquindio.reciclapp.data.dao.CitaDAO
import co.edu.uniquindio.reciclapp.data.dao.MaterialDAO
import co.edu.uniquindio.reciclapp.data.dao.UsuarioDAO
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.Material
import co.edu.uniquindio.reciclapp.model.Usuario

@Database(
    entities = [Usuario::class, Cita::class, Material::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class UsuarioDB: RoomDatabase() {
    abstract fun citaDAO(): CitaDAO
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun materialDAO(): MaterialDAO
}