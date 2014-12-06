package desarrollandoandroid.ejemploactivityclassintentclass;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Creado por Pablo Bascuñana Saiz el 2/12/14.
 */
public class MainActivity extends ActionBarActivity {

    public static final int CODIGO_SOLICITUD_DEL_TEXTO = 1;

    Button mButtonImplicit, mButtonIntents;
    TextView mResultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonImplicit = (Button) findViewById(R.id.buttonImplicitIntent);
        mButtonIntents = (Button) findViewById(R.id.buttonUsandoIntents);
        mResultText = (TextView) findViewById(R.id.textViewResultado);

        mButtonImplicit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent empezarOtraActividadIntent = new Intent(MainActivity.this, ImplicitActivity.class);
                startActivityForResult(empezarOtraActividadIntent, CODIGO_SOLICITUD_DEL_TEXTO);
            }
        });

        mButtonIntents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent empezarOtraActividadIntent = new Intent(MainActivity.this, IntentsActivity.class);
                startActivity(empezarOtraActividadIntent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == CODIGO_SOLICITUD_DEL_TEXTO && resultCode == RESULT_OK){
            String nombreText = data.getStringExtra("mensaje1");
            String apellidosText = data.getStringExtra("mensaje2");
            mResultText.setText(nombreText + " " + apellidosText);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
