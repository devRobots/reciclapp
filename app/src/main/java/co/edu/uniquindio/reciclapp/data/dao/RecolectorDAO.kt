package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Recolector

@Dao
interface RecolectorDAO {
    @Query("SELECT * FROM Recolector")
    suspend fun obtenerTodas(): List<Recolector>

    @Query("SELECT * FROM Recolector WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Recolector

    @Update
    suspend fun actualizar(recolector: Recolector)

    @Insert
    suspend fun insertar(recolector: List<Recolector>)

    @Delete
    suspend fun eliminar(recolector: Recolector)
}