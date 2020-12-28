package cr.fnx.ingresausuario;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class muestraDatos extends AppCompatActivity {

    TextView dspNmbr;
    TextView dsplgrFN;
    TextView dsptlfn;
    TextView dspcrr;
    TextView dspdscrpcn;
    Button edtr, Slvr;
    EditText dscrpcn, nombreCmplt, crr, tlfn, seleccionFN;
//    String[] datosusuario = new String[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_datos);

        Bundle parametros =     getIntent().getExtras();
        String dspnmbrCmplt =   parametros.getString(getResources().getString(R.string.dsplgrNmbrCmplt));
        String dsplgrFchNcmnto =    parametros.getString(getResources().getString(R.string.dsplgrFchNcmnto));
        String dsplgtlfn =      parametros.getString(getResources().getString(R.string.dsplgrtlfn));
        String dsplgcrr =       parametros.getString(getResources().getString(R.string.dsplgrcrr));
        String dsplgdscrpcn =   parametros.getString(getResources().getString(R.string.dsplgrdscrpcn));

        Intent intent = getIntent();

        dspNmbr =       (TextView)findViewById(R.id.dspNmbr);
        dsplgrFN =      (TextView)findViewById(R.id.dspFN);
        dsptlfn =       (TextView)findViewById(R.id.dsptlfn);
        dspcrr =        (TextView)findViewById(R.id.dspcrr);
        dspdscrpcn =    (TextView)findViewById(R.id.dspdscrpcn);
        edtr =          (Button)findViewById(R.id.edtr);
        Slvr =          (Button)findViewById(R.id.Slvr);

        dspNmbr.setText(dspnmbrCmplt);

        dsplgrFN.setText(dsplgrFchNcmnto);
        dsptlfn.setText(dsplgtlfn);
        dspcrr.setText(dsplgcrr);
        dspdscrpcn.setText(dsplgdscrpcn);

        edtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editar = new Intent(muestraDatos.this, MainActivity.class);
                editar.putExtra(getResources().getString(R.string.dsplgrNmbrCmplt), nombreCmplt.toString());
                editar.putExtra(getResources().getString(R.string.dsplgrFchNcmnto),seleccionFN.toString());
                editar.putExtra(getResources().getString(R.string.dsplgrtlfn), tlfn.toString());
                editar.putExtra(getResources().getString(R.string.dsplgrcrr), crr.toString());
                editar.putExtra(getResources().getString(R.string.dsplgrdscrpcn), dscrpcn.toString());
                startActivity(editar);

            }


       });

        Slvr.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
           public void onClick(View v) {

                String[] datosusuario;
                datosusuario = new String[5];
                datosusuario[0]=dspnmbrCmplt;
                datosusuario[1]=dsplgrFchNcmnto;
                datosusuario[2]=dsplgtlfn;
                datosusuario[3]=dsplgcrr;
                datosusuario[4]=dsplgdscrpcn;

               for (int i = 0; i < datosusuario.length; i++){
                   Toast.makeText(muestraDatos.this, datosusuario[i],Toast.LENGTH_SHORT).show();
               }
                Toast.makeText(muestraDatos.this,"Información salvada con éxito",Toast.LENGTH_LONG).show();
                Toast.makeText(muestraDatos.this,"Fin de la aplicación", Toast.LENGTH_LONG).show();

            }
        });
    }

}