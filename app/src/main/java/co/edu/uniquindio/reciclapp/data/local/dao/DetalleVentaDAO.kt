package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.DetalleVenta

@Dao
interface DetalleVentaDAO {
    @Query("SELECT * FROM DetalleVenta")
    suspend fun obtenerTodas(): List<DetalleVenta>

    @Query("SELECT * FROM DetalleVenta WHERE id = :id")
    suspend fun obtenerPorId(id: Int): DetalleVenta

    @Update
    suspend fun actualizar(detalleVenta: DetalleVenta)

    @Insert
    suspend fun insertar(detalleVenta: List<DetalleVenta>)

    @Delete
    suspend fun eliminar(detalleVenta: DetalleVenta)
}