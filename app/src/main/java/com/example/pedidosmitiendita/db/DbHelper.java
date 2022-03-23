package com.example.pedidosmitiendita.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "tienda.db";
    public static final String TABLE_PEDIDO = "t_pedidos";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PEDIDO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "cliente TEXT NOT NULL," +
                "pedido TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "envio TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PEDIDO);
        onCreate(sqLiteDatabase);

    }
}
