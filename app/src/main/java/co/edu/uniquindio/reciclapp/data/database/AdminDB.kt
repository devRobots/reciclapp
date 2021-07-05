package co.edu.uniquindio.reciclapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.edu.uniquindio.reciclapp.data.Converters
import co.edu.uniquindio.reciclapp.data.dao.*
import co.edu.uniquindio.reciclapp.model.*

@Database(
    entities = [
        Administrador::class, Cita::class, Comprador::class, DetalleVenta::class,
        Material::class, Recolector::class, Usuario::class, Venta::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AdminDB : RoomDatabase() {
    abstract fun administradorDAO(): AdministradorDAO
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun citaDAO(): CitaDAO
    abstract fun compradorDAO(): CompradorDAO
    abstract fun detalleVentaDAO(): DetalleVentaDAO
    abstract fun materialDAO(): MaterialDAO
    abstract fun recolectorDAO(): RecolectorDAO
    abstract fun ventaDAO(): VentaDAO
}