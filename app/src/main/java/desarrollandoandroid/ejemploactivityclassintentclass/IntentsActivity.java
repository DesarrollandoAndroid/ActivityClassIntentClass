package desarrollandoandroid.ejemploactivityclassintentclass;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import org.apache.http.protocol.HTTP;

import desarrollandoandroid.ejemploactivityclassintentclass.R;

/**
 * Creado por Pablo Bascuñana Saiz el 3/12/14.
 */
public class IntentsActivity extends Activity {

    Button mButtonVerWeb, mButtonMarcarTelefono, mButtonHacerLlamada, mButtonAddContactos, mButtonAlarma,
           mButtonEnviarMail, mButtonHacerFoto, mButtonHacerVideo, mButtonMostrarMapa, mButtonCompartir;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intents_layout);

        mButtonVerWeb = (Button) findViewById(R.id.buttonWeb);
        mButtonMarcarTelefono = (Button) findViewById(R.id.buttonTelefono);
        mButtonHacerLlamada = (Button) findViewById(R.id.buttonLlamada);
        mButtonAddContactos = (Button) findViewById(R.id.buttonContactos);
        mButtonAlarma = (Button) findViewById(R.id.buttonAlarma);
        mButtonEnviarMail = (Button) findViewById(R.id.buttonCorreo);
        mButtonHacerFoto = (Button) findViewById(R.id.buttonFoto);
        mButtonHacerVideo = (Button) findViewById(R.id.buttonVideo);
        mButtonMostrarMapa = (Button) findViewById(R.id.buttonMapa);
        mButtonCompartir = (Button) findViewById(R.id.buttonCompartir);

        mButtonVerWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verWebIntent = new Intent(Intent.ACTION_VIEW);
                verWebIntent.setData(Uri.parse(getResources().getString(R.string.desarrollandoAndroid)));
                startActivity(verWebIntent);
            }
        });

        mButtonMarcarTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent marcarTelefonoIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(marcarTelefonoIntent);
            }
        });

        mButtonHacerLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamarTelefonoIntent = new Intent(Intent.ACTION_DIAL);   // Necesario pulsar la tecla llamar.
              //  Intent llamarTelefonoIntent = new Intent(Intent.ACTION_DIAL);  // Para llamar directamente.
                llamarTelefonoIntent.setData(Uri.parse("tel:" + getResources().getString(R.string.llamarTelefono)));
                startActivity(llamarTelefonoIntent);
            }
        });

        mButtonAddContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anadirContactoIntent = new Intent(Intent.ACTION_INSERT);
                anadirContactoIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                startActivity(anadirContactoIntent);
            }
        });

        mButtonAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enviarSMSIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(enviarSMSIntent);
            }
        });

        mButtonEnviarMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enviarEmailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
                        getResources().getString(R.string.correo), null));
                enviarEmailIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.dudas));
                startActivity(Intent.createChooser(enviarEmailIntent, getResources().getString(R.string.enviar)));
            }
        });

        mButtonHacerFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent hacerFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivity(hacerFotoIntent);
            }
        });

        mButtonHacerVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent grabarVideoIntent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
                startActivity(grabarVideoIntent);
            }
        });

        mButtonMostrarMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarMapaIntent = new Intent(Intent.ACTION_VIEW);
                mostrarMapaIntent.setData(Uri.parse(getResources().getString(R.string.coordenadas)));
                startActivity(mostrarMapaIntent);
            }
        });

        mButtonCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compartirTextoIntent = new Intent();
                compartirTextoIntent.setAction(Intent.ACTION_SEND);
                compartirTextoIntent.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.desarrollandoAndroid));
                compartirTextoIntent.setType("text/plain");
                startActivity(compartirTextoIntent);
            }
        });
    }
}
