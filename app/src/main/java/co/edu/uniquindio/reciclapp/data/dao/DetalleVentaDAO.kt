package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.DetalleVenta

@Dao
interface DetalleVentaDAO {
    @Query("SELECT * FROM DetalleVenta")
    fun obtenerTodas(): List<DetalleVenta>

    @Query("SELECT * FROM DetalleVenta WHERE id = :id")
    fun obtenerPorId(id: Int): DetalleVenta

    @Update
    fun actualizar(detalleVenta: DetalleVenta)

    @Insert
    fun insertar(detalleVenta: List<DetalleVenta>)

    @Delete
    fun eliminar(detalleVenta: DetalleVenta)
}