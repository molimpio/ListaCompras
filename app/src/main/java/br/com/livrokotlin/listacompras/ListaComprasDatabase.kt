package br.com.livrokotlin.listacompras

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class ListaComprasDatabase(context: Context) : ManagedSQLiteOpenHelper
    (ctx = context, name = "listacompras.db", version = 1) {

    companion object {
        private var instance: ListaComprasDatabase? = null

        @Synchronized
    fun getInstance(ctx: Context): ListaComprasDatabase {
            if (instance == null) {
                instance = ListaComprasDatabase(ctx.applicationContext)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable("produtos", true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                "nome" to TEXT,
                "quantidade" to INTEGER,
                "valor" to REAL,
                "foto" to BLOB)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}

val Context.database: ListaComprasDatabase get() = ListaComprasDatabase.getInstance(applicationContext)