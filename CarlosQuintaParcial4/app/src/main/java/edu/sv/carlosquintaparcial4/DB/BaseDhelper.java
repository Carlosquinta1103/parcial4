package edu.sv.carlosquintaparcial4.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NOMBRE ="parcial4_venta_auto";
    private static final String TABLA_MD_CLIENTES ="MD_CLIENTES";

    public BaseDhelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLA_MD_CLIENTES+"(" +
                "ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT," +
                "sNombreCliente TEXT NOT NULL," +
                "sApellidosCliente TEXT NOT NULL," +
                "sDireccionCliente NOT NULL," +
                "sCuidadCliente TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLA_MD_CLIENTES);
        onCreate(sqLiteDatabase);
    }
}
