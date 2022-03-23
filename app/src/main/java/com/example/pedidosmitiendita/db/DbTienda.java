package com.example.pedidosmitiendita.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbTienda extends DbHelper{

    Context context;

    public DbTienda(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertatienda(String cliente, String pedido, String telefono, String envio ){

        long id = 0;

        try {

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("cliente", cliente);
            values.put("pedido", pedido);
            values.put("telefono", telefono);
            values.put("envio", envio);

            id = db.insert(TABLE_PEDIDO, null, values);
        } catch(Exception ex){
            ex.toString();
        }



        return  id;
    }
}
