package com.epeinado.androidBichosQR;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
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
        setContentView(R.layout.bichosppal);
//        findViewById(R.id.get_camera_parameters).setOnClickListener(getCameraParameters);
//        findViewById(R.id.scan_product).setOnClickListener(scanProduct);
        findViewById(R.id.scan_qr_code).setOnClickListener(scanQRCode);
//        findViewById(R.id.scan_anything).setOnClickListener(scanAnything);
//        findViewById(R.id.search_book_contents).setOnClickListener(searchBookContents);
//        findViewById(R.id.encode_url).setOnClickListener(encodeURL);
//        findViewById(R.id.encode_email).setOnClickListener(encodeEmail);
//        findViewById(R.id.encode_phone).setOnClickListener(encodePhone);
//        findViewById(R.id.encode_sms).setOnClickListener(encodeSMS);
//        findViewById(R.id.encode_contact).setOnClickListener(encodeContact);
//        findViewById(R.id.encode_location).setOnClickListener(encodeLocation);
//        findViewById(R.id.encode_hidden_data).setOnClickListener(encodeHiddenData);
//        findViewById(R.id.encode_bad_data).setOnClickListener(encodeBadData);
//        findViewById(R.id.share_via_barcode).setOnClickListener(shareViaBarcode);
//        findViewById(R.id.run_benchmark).setOnClickListener(runBenchmark);
    }

    private final Button.OnClickListener scanQRCode = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            IntentIntegrator integrator = new IntentIntegrator(Main.this);
            integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//      if (item.getItemId() == R.id.menu_about) {
//        int versionCode;
//        String versionName;
//        try {
//          PackageInfo info = getPackageManager().getPackageInfo(PACKAGE_NAME, 0);
//          versionCode = info.versionCode;
//          versionName = info.versionName;
//        } catch (PackageManager.NameNotFoundException ignored) {
//          versionCode = 0;
//          versionName = "unknown";
//        }
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle(
//            getString(R.string.app_name) + ' ' + versionName + " (" + versionCode + ')');
//        builder.setMessage(getString(R.string.about_message));
//        builder.setPositiveButton(R.string.ok_button, null);
//        builder.show();
//
//      }
//      return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (result != null) {
            String contents = result.getContents();
            Datos datos = new Datos(contents);
            Intent i = new Intent(Main.this, Form.class);
            i.putExtra("cliente", datos.getCliente());
            i.putExtra("ptoControl", datos.getPuntoControl());
            startActivity(i);
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
