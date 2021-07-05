package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Venta

@Dao
interface VentaDAO {
    @Query("SELECT * FROM Venta")
    fun obtenerTodas(): List<Venta>

    @Query("SELECT * FROM Venta WHERE id = :id")
    fun obtenerPorId(id: Int): Venta

    @Update
    fun actualizar(venta: Venta)

    @Insert
    fun insertar(venta: List<Venta>)

    @Delete
    fun eliminar(venta: Venta)
}