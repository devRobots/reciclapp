package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Recolector

@Dao
interface RecolectorDAO {
    @Query("SELECT * FROM Recolector")
    fun obtenerTodas(): List<Recolector>

    @Query("SELECT * FROM Recolector WHERE id = :id")
    fun obtenerPorId(id: Int): Recolector

    @Update
    fun actualizar(recolector: Recolector)

    @Insert
    fun insertar(recolector: List<Recolector>)

    @Delete
    fun eliminar(recolector: Recolector)
}