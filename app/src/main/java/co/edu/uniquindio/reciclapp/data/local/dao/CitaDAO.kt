package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Cita
import co.edu.uniquindio.reciclapp.model.MaterialCita
import co.edu.uniquindio.reciclapp.model.Usuario

@Dao
interface CitaDAO {
    @Query("SELECT * FROM Cita")
    suspend fun obtenerTodas(): List<Cita>

    @Transaction
    @Query("SELECT * FROM Cita")
    suspend fun obtenerMateriales(): List<MaterialCita>

    @Query("SELECT * FROM Cita WHERE id = :id")
    suspend fun obtenerPorId(id: Long): Cita?

    @Query("SELECT * FROM Cita WHERE estado IN ('EN_PROCESO', 'APLAZADO', 'ACEPTADO') AND idUsuario = :usuarioId")
    suspend fun obtenerPendientesPorUsuario(usuarioId: Long): List<Cita>

    @Query("SELECT * FROM Cita WHERE estado IN ('CANCELADO', 'COMPLETADO') AND idUsuario = :usuarioId")
    suspend fun obtenerFinalizadosPorUsuario(usuarioId: Long): List<Cita>

    @Update
    suspend fun actualizar(cita: Cita)

    @Insert
    suspend fun insertar(cita: List<Cita>)

    @Delete
    suspend fun eliminar(cita: Cita)
}