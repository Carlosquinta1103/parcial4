package edu.sv.carlosquintaparcial4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.sv.carlosquintaparcial4.DB.dbContactos;

public class NuevoActivity extends AppCompatActivity {

    EditText txtsNombreCliente, txtsApellidosCliente, txtsDireccionCliente,txtsCuidadCliente;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtsNombreCliente = findViewById(R.id.edt_nombre);
        txtsApellidosCliente = findViewById(R.id.edt_apellido);
        txtsDireccionCliente = findViewById(R.id.edt_direccion);
        txtsCuidadCliente = findViewById(R.id.edt_ciudad);

        btnGuarda = findViewById(R.id.btnGuarda);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!txtsNombreCliente.getText().toString().equals("") && !txtsApellidosCliente.getText().toString().equals("")) {

                    dbContactos dbContactos = new dbContactos(NuevoActivity.this);
                    long id = dbContactos.insertarContacto(txtsNombreCliente.getText().toString(), txtsApellidosCliente.getText().toString(), txtsDireccionCliente.getText().toString(),txtsCuidadCliente.getText().toString());

                    if (id > 0) {
                        Toast.makeText(NuevoActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(NuevoActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(NuevoActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiar() {
        txtsNombreCliente.setText("");
        txtsApellidosCliente.setText("");
        txtsDireccionCliente.setText("");
        txtsCuidadCliente.setText("");
    }
}