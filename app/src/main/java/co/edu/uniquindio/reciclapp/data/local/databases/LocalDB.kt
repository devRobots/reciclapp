package co.edu.uniquindio.reciclapp.data.local.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.edu.uniquindio.reciclapp.data.local.misc.Converters
import co.edu.uniquindio.reciclapp.data.local.dao.*
import co.edu.uniquindio.reciclapp.model.*

@Database(
    entities = [
        Administrador::class, Cita::class, Comprador::class, Material::class,
        Recolector::class, Usuario::class, Venta::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class LocalDB : RoomDatabase() {
    abstract fun administradorDAO(): AdministradorDAO
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun citaDAO(): CitaDAO
    abstract fun compradorDAO(): CompradorDAO
    abstract fun materialDAO(): MaterialDAO
    abstract fun recolectorDAO(): RecolectorDAO
    abstract fun ventaDAO(): VentaDAO
}