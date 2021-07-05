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
    fun obtenerTodas(): List<Cita>

    @Query("SELECT * FROM Cita WHERE id = :id")
    fun obtenerPorId(id: Int): Cita

    @Update
    fun actualizar(cita: Cita)

    @Insert
    fun insertar(cita: List<Cita>)

    @Delete
    fun eliminar(cita: Cita)
}