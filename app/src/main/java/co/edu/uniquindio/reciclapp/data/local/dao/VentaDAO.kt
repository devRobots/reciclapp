package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.MaterialVenta
import co.edu.uniquindio.reciclapp.model.Venta

@Dao
interface VentaDAO {
    @Query("SELECT * FROM Venta")
    suspend fun obtenerTodas(): List<Venta>

    @Transaction
    @Query("SELECT * FROM Venta")
    suspend fun obtenerMateriales(): List<MaterialVenta>

    @Query("SELECT * FROM Venta WHERE id = :id")
    suspend fun obtenerPorId(id: kotlin.Long): Venta?

    @Update
    suspend fun actualizar(venta: Venta)

    @Insert
    suspend fun insertar(venta: List<Venta>)

    @Delete
    suspend fun eliminar(venta: Venta)
}