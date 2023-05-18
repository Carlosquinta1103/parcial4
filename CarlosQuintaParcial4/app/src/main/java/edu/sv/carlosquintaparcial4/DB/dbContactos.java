package edu.sv.carlosquintaparcial4.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class dbContactos extends BaseDhelper {

    Context context;
    private String TABLA_MD_CLIENTES;

    public dbContactos(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarContacto( String sNombreCliente, String sApellidosCliente,String sDireccionCliente,String sCuidadCliente) {

        long id = 0;

        try {
            BaseDhelper dbHelper = new BaseDhelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("sNombreCliente", sNombreCliente);
            values.put("sApellidosCliente", sApellidosCliente);
            values.put("sDireccionCliente", sDireccionCliente);
            values.put("sCuidadCliente", sCuidadCliente);

            id = db.insert(TABLA_MD_CLIENTES, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }
}
