package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText jetcantidad, jetvalor;
     TextView jtveunovb, jtvedosvd, jtvetresviva , jtvecuatronp;
     TextView jtvventabruta, jtvdescuento, jtvvaloriva, jtvventaneta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulo por defecto y asociar objetos Java con
        //objetos Xml
        getSupportActionBar().hide();
        //Relacionamos los objetos xml con los objetos java
        jetcantidad = findViewById(R.id.etcantidad);
        jetvalor = findViewById(R.id.etvalor);
        jtveunovb = findViewById(R.id.tveunovb);
        jtvedosvd = findViewById(R.id.tvedosvd);
        jtvetresviva = findViewById(R.id.tvetresviva);
        jtvecuatronp = findViewById(R.id.tvecuatronp);
        jtvventabruta = findViewById(R.id.tvventabruta);
        jtvdescuento = findViewById(R.id.tvdescuento);
        jtvvaloriva = findViewById(R.id.tvvaloriva);
        jtvventaneta = findViewById(R.id.tvventaneta);

    }//FIN ONCREATE

    public void Calcular(View view){
        String cantidad,valor;
        cantidad = jetcantidad.getText().toString();
        valor = jetvalor.getText().toString();

        if (valor.isEmpty() || cantidad.isEmpty()) {
            Toast.makeText(this, "Las cantidades son requeridas", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }else{
           int cantidad1;
           double valor1, venta_bruta, descuento, iva, venta_neta;
            //Conversiones de texto a numerico
            cantidad1 = Integer.parseInt(cantidad);
            valor1 = Double.parseDouble(valor);
            ClsOperaciones Obj_operaciones = new ClsOperaciones();
            venta_bruta = Obj_operaciones.Calcular_valor_bruto(valor1,cantidad1);
            descuento = Obj_operaciones.Calcular_descuento(venta_bruta,cantidad1);
            iva = Obj_operaciones.Calcular_iva(venta_bruta);
            venta_neta = Obj_operaciones.Calcular_neto(venta_bruta,descuento,iva );
            //Mostrar los resultados
            jtvventabruta.setText(String.valueOf(venta_bruta));
            jtvdescuento.setText(String.valueOf(descuento));
            jtvvaloriva.setText(String.valueOf(iva));
            jtvventaneta.setText(String.valueOf(venta_neta));



        }
    }//Fin Calcular

    public void Limpiar(View view){
        jetcantidad.setText("");
        jetvalor.setText("");
        jtvventabruta.setText("0");
        jtvdescuento.setText("0");
        jtvvaloriva.setText("0");
        jtvventaneta.setText("0");
    }
}