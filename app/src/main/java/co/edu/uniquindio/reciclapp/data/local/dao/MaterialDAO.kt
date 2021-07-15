package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Material

@Dao
interface MaterialDAO {
    @Query("SELECT * FROM Material")
    suspend fun obtenerTodas(): List<Material>

    @Query("SELECT * FROM Material WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Material

    @Update
    suspend fun actualizar(material: Material)

    @Insert
    suspend fun insertar(material: List<Material>)

    @Delete
    suspend fun eliminar(material: Material)
}