package co.edu.uniquindio.reciclapp.data.local.misc

import androidx.room.TypeConverter
import co.edu.uniquindio.reciclapp.model.*
import com.google.gson.Gson
import java.util.*

class Converters {
    // Conversores de Fecha
    @TypeConverter
    fun longToDate(value: Long?): Date? {
        return value?.let { Date(it) }
    }
    @TypeConverter
    fun dateToLong(date: Date?): Long? {
        return date?.time
    }

    // Conversores de Cita
    @TypeConverter
    fun gsonToCita(json: String): Cita? {
        return Gson().fromJson(json, Cita::class.java)
    }
    @TypeConverter
    fun citaToGson(cita: Cita): String? {
        return Gson().toJson(cita)
    }

    // Conversores de Usuario
    @TypeConverter
    fun gsonToUsuario(json: String?): Usuario? {
        return Gson().fromJson(json, Usuario::class.java)
    }
    @TypeConverter
    fun usuarioToGson(usuario: Usuario?): String? {
        return Gson().toJson(usuario)
    }

    // Conversores de Administrador
    @TypeConverter
    fun gsonToAdministrador(json: String?): Administrador? {
        return Gson().fromJson(json, Administrador::class.java)
    }
    @TypeConverter
    fun administradorToGson(administrador: Administrador?): String? {
        return Gson().toJson(administrador)
    }

    // Conversores de Recolector
    @TypeConverter
    fun gsonToRecolector(json: String): Recolector? {
        return Gson().fromJson(json, Recolector::class.java)
    }
    @TypeConverter
    fun recolectorToGson(recolector: Recolector): String? {
        return Gson().toJson(recolector)
    }

    // Conversores de Venta
    @TypeConverter
    fun gsonToVenta(json: String): Venta? {
        return Gson().fromJson(json, Venta::class.java)
    }
    @TypeConverter
    fun ventaToGson(venta: Venta): String? {
        return Gson().toJson(venta)
    }

    // Conversores de Material
    @TypeConverter
    fun gsonToMaterial(json: String): Material? {
        return Gson().fromJson(json, Material::class.java)
    }
    @TypeConverter
    fun materialToGson(material: Material): String? {
        return Gson().toJson(material)
    }

    // Conversores de Comprador
    @TypeConverter
    fun gsonToComprador(json: String): Comprador? {
        return Gson().fromJson(json, Comprador::class.java)
    }
    @TypeConverter
    fun compradorToGson(comprador: Comprador): String? {
        return Gson().toJson(comprador)
    }
}