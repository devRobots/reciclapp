package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Material

@Dao
interface MaterialDAO {
    @Query("SELECT * FROM Material")
    fun obtenerTodas(): List<Material>

    @Query("SELECT * FROM Material WHERE id = :id")
    fun obtenerPorId(id: Int): Material

    @Update
    fun actualizar(material: Material)

    @Insert
    fun insertar(material: List<Material>)

    @Delete
    fun eliminar(material: Material)
}