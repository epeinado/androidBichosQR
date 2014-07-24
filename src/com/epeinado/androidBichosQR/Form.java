package com.epeinado.androidBichosQR;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * User: epeinado
 * Date: 14/07/14
 * Time: 14:10
 */
public class Form extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        int cliente = extras.getInt("cliente");
        int ptoControl = extras.getInt("ptoControl");

        TextView clienteV = (TextView) findViewById(R.id.cliente);
        TextView ptoCtrolV = (TextView) findViewById(R.id.ptoControl);

//        clienteV.setText(Integer.toString(cliente));
//        ptoCtrolV.setText(Integer.toString(ptoControl));

        setContentView(R.layout.logo);
    }
}
