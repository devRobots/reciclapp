package co.edu.uniquindio.reciclapp.data.local

import android.app.Application
import android.content.Context
import androidx.room.Room
import co.edu.uniquindio.reciclapp.data.local.databases.LocalDB
import co.edu.uniquindio.reciclapp.data.local.databases.ConfigDB

class RoomApp(val context: Context): Application() {
    val local = Room.databaseBuilder(context, LocalDB::class.java, "local").build()
    val config = Room.databaseBuilder(context, ConfigDB::class.java, "config").build()
}