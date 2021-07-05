package co.edu.uniquindio.reciclapp.data

import android.app.Application
import androidx.room.Room
import co.edu.uniquindio.reciclapp.data.database.AdminDB
import co.edu.uniquindio.reciclapp.data.database.UsuarioDB

class RoomApp: Application() {
    val usuario = Room.databaseBuilder(this, UsuarioDB::class.java, "usuario").build()
    val admin = Room.databaseBuilder(this, AdminDB::class.java, "admin").build()
}