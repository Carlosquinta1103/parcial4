package edu.sv.carlosquintaparcial4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.sv.carlosquintaparcial4.DB.BaseDhelper;

public class MainActivity extends AppCompatActivity {
    Button bt_crearbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_crearbase = findViewById(R.id.btn_crearbase);

        bt_crearbase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            BaseDhelper dbhelper = new BaseDhelper(MainActivity.this);
                SQLiteDatabase db = dbhelper.getWritableDatabase();
                if (db != null){
                    Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity.this, "Error en la creacion", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}