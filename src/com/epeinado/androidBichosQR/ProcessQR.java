package com.epeinado.androidBichosQR;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * User: epeinado
 * Date: 14/07/14
 * Time: 14:10
 */
public class ProcessQR extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        long empresa = extras.getLong("empresa");
        long cliente = extras.getLong("cliente");
        long ptoControl = extras.getLong("ptoControl");
        setContentView(R.layout.formulario_update);

        TextView empresaV = (TextView) findViewById(R.id.empresa);
        TextView clienteV = (TextView) findViewById(R.id.cliente);
        TextView ptoCtrolV = (TextView) findViewById(R.id.ptoControl);

        empresaV.setText(Long.toString(empresa));
        clienteV.setText(Long.toString(cliente));
        ptoCtrolV.setText(Long.toString(ptoControl));


    }
}
