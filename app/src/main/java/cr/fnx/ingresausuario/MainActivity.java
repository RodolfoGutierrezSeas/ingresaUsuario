package cr.fnx.ingresausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText dscrpcn, nombreCmplt, crr, tlfn, seleccionFN;
    Button sgte, eligedate;
    DatePickerDialog fechaPicker;
    int ano, mes, dia;
    String DdNcmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreCmplt =   (EditText)findViewById(R.id.nombreCmplt);
        seleccionFN =   (EditText)findViewById(R.id.seleccionFN);
        dscrpcn =       (EditText)findViewById(R.id.dscrpcn);
        crr =           findViewById(R.id.crr);
        tlfn =          findViewById(R.id.tlfn);
        sgte =          (Button)findViewById(R.id.sgte);
        eligedate=      (Button)findViewById(R.id.eligedate);

        eligedate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar Calendario = Calendar.getInstance();

                ano = Calendario.get(Calendar.YEAR);
                mes = Calendario.get(Calendar.MONTH);
                dia = Calendario.get(Calendar.DAY_OF_MONTH);
                fechaPicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        DdNcmnt = (dayOfMonth + "/" + (month + 1) + "/" + year);
                        seleccionFN.setText(DdNcmnt);
                    }
                }, ano, mes, dia);
                fechaPicker.show();
            }
        });

        sgte.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,muestraDatos.class);

                intent.putExtra(getResources().getString(R.string.dsplgrNmbrCmplt), nombreCmplt.getText().toString());
                intent.putExtra(getResources().getString(R.string.dsplgrFchNcmnto),seleccionFN.getText().toString());
                intent.putExtra(getResources().getString(R.string.dsplgrtlfn),tlfn.getText().toString());
                intent.putExtra(getResources().getString(R.string.dsplgrcrr),crr.getText().toString());
                intent.putExtra(getResources().getString(R.string.dsplgrdscrpcn),dscrpcn.getText().toString());

                startActivity(intent);
            }
        });

    }
}