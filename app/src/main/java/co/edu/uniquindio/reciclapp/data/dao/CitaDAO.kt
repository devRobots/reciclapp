package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import co.edu.uniquindio.reciclapp.model.Cita

@Dao
interface CitaDAO {
    @Query("SELECT * FROM Cita")
    suspend fun obtenerTodas(): List<Cita>

    @Query("SELECT * FROM Cita WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Cita

    @Update
    suspend fun actualizar(cita: Cita)

    @Insert
    suspend fun insertar(cita: List<Cita>)

    @Delete
    suspend fun eliminar(cita: Cita)
}