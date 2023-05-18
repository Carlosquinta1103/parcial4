package edu.sv.carlosquintaparcial4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.sv.carlosquintaparcial4.DB.BaseDhelper;

public class MainActivity extends AppCompatActivity {
    Button bt_crearbase, bt_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_crearbase = findViewById(R.id.btn_crearbase);
        bt_registro = findViewById(R.id.btn_registro);
        bt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),NuevoActivity.class);
                startActivity(intent);
            }
        });
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
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nuevo, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_nuevos:
                nuevoRegistro();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegistro(){
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }
}