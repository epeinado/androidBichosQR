package com.epeinado.androidBichosQR;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.epeinado.androidBichosQR.domain.DatosFormulario;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * User: epeinado
 * Date: 14/07/14
 * Time: 12:44
 */
public class Main extends Activity {

    private static final String PACKAGE_NAME = Main.class.getPackage().getName();


    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        IntentIntegrator integrator = new IntentIntegrator(Main.this);
        integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
    }

//    private final Button.OnClickListener scanQRCode = new Button.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            IntentIntegrator integrator = new IntentIntegrator(Main.this);
//            integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
//        }
//    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (result != null) {
            String contents = result.getContents();
            if (contents.contains("updateInfo")) {
//            El código es para actualizar un punto de control
                DatosFormulario datos = new DatosFormulario(contents);
                Intent i = new Intent(Main.this, ProcessQR.class);
                i.putExtra("empresa", datos.getEmpresa());
                i.putExtra("cliente", datos.getCliente());
                i.putExtra("ptoControl", datos.getPuntoControl());
                startActivity(i);
            } else if (contents.contains("inicioFinVisita")) {
//            El código es para iniciar o finalizar la visita

            } else {
                System.out.print("ERROR AL SCANNEAR CÓDIGO");
            }
        }
    }

    private void showDialog(int title, CharSequence message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok_button, null);
        builder.show();
    }
}
