package com.example.pedidosmitiendita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pedidosmitiendita.db.DbTienda;

public class NuevoActivity extends AppCompatActivity {

    EditText txtcliente, txtnombre, txttelefono, txtenvio;
    Button btnpedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtcliente = findViewById(R.id.txtcliente);
        txtnombre = findViewById(R.id.txtnombre);
        txttelefono = findViewById(R.id.txttelefono);
        txtenvio = findViewById(R.id.txtenvio);
        btnpedido = findViewById(R.id.btnpedido);

        btnpedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbTienda dbTienda = new DbTienda(NuevoActivity.this);
                long id = dbTienda.insertatienda(txtcliente.getText().toString(),txtnombre.getText().toString(),txttelefono.getText().toString(),txtenvio.getText().toString());

                if(id > 0){
                    Toast.makeText(NuevoActivity.this, "Pedido Realizado", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(NuevoActivity.this, "Error al Realizar el Pedido", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void limpiar(){
        txtcliente.setText("");
        txtnombre.setText("");
        txttelefono.setText("");
        txtenvio.setText("");
    }
}