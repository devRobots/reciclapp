package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Venta

@Dao
interface VentaDAO {
    @Query("SELECT * FROM Venta")
    suspend fun obtenerTodas(): List<Venta>

    @Query("SELECT * FROM Venta WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Venta

    @Update
    suspend fun actualizar(venta: Venta)

    @Insert
    suspend fun insertar(venta: List<Venta>)

    @Delete
    suspend fun eliminar(venta: Venta)
}