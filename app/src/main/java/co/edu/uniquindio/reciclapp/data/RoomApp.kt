package co.edu.uniquindio.reciclapp.data

import android.app.Application
import android.content.Context
import androidx.room.Room
import co.edu.uniquindio.reciclapp.data.database.AdminDB
import co.edu.uniquindio.reciclapp.data.database.ConfigDB
import co.edu.uniquindio.reciclapp.data.database.UsuarioDB

class RoomApp(val context: Context): Application() {
    var usuario = Room.databaseBuilder(context, UsuarioDB::class.java, "usuario").build()
    val admin = Room.databaseBuilder(context, AdminDB::class.java, "admin").build()
    val config = Room.databaseBuilder(context, ConfigDB::class.java, "config").build()
}