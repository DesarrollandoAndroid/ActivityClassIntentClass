package desarrollandoandroid.ejemploactivityclassintentclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import desarrollandoandroid.ejemploactivityclassintentclass.R;

/**
 * Creado por Pablo Bascuñana Saiz el 2/12/14.
 */
public class ImplicitActivity extends Activity {

    TextView mTextNombre, mTextApellidos;
    Button mEnviarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_layout);

        mTextNombre = (TextView) findViewById(R.id.textViewNombre);
        mTextApellidos = (TextView) findViewById(R.id.textViewApellido);
        mEnviarDatos = (Button) findViewById(R.id.buttonEnviarResultados);

        mEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = mTextNombre.getText().toString();
                String apellidos = mTextApellidos.getText().toString();

                Intent resultadoIntent = new Intent();
                resultadoIntent.putExtra("mensaje1", nombre);
                resultadoIntent.putExtra("mensaje2", apellidos);

                setResult(RESULT_OK, resultadoIntent);
                finish();
            }
        });
    }
}
