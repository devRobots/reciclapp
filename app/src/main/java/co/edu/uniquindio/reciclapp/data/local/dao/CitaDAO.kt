package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.Usuario

@Dao
interface CitaDAO {
    @Query("SELECT * FROM Cita")
    suspend fun obtenerTodas(): List<Cita>

    @Query("SELECT * FROM Cita WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Cita

    @Query("SELECT * FROM Cita WHERE estado IN ('EN_PROCESO', 'APLAZADO', 'ACEPTADO') AND usuario = :usuario")
    suspend fun obtenerPendientesPorUsuario(usuario: Usuario): List<Cita>

    @Query("SELECT * FROM Cita WHERE estado IN ('CANCELADO', 'COMPLETADO') AND usuario = :usuario")
    suspend fun obtenerFinalizadosPorUsuario(usuario: Usuario): List<Cita>

    @Update
    suspend fun actualizar(cita: Cita)

    @Insert
    suspend fun insertar(cita: List<Cita>)

    @Delete
    suspend fun eliminar(cita: Cita)
}