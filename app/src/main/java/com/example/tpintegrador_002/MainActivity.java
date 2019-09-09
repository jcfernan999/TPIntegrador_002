package com.example.tpintegrador_002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioButton;

import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    EditText vetDolar;
    EditText vetEuros;
    EditText vetCambio;
    RadioButton vrbDolarEuros;
    RadioButton vrbEurosDolar;
    Button vbtnConvertir;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        vetDolar = (EditText)this.findViewById(R.id.edtDolares);
        vetEuros = (EditText)this.findViewById(R.id.edtEuros);
        vetCambio = (EditText)this.findViewById(R.id.edtCambio);

        vrbDolarEuros = (RadioButton)this.findViewById(R.id.rbDolarAeuro);
        vrbEurosDolar = (RadioButton)this.findViewById(R.id.rbEuroAdolar);

        vbtnConvertir = (Button)this.findViewById(R.id.btnConvertir);

        vbtnConvertir.setOnClickListener(this);
        vrbDolarEuros.setOnClickListener(this);
        vrbEurosDolar.setOnClickListener(this);

        vetEuros.setEnabled(false);
    }

    protected void convertirDolarEuros() {
        double val, aux = 0.91;

        if ("".equals(vetDolar.getText().toString())){
            Toast.makeText(MainActivity.this,"Ingrese Cantidad a Convertir.", Toast.LENGTH_SHORT).show();

        }
        else{
            val = Double.parseDouble(vetDolar.getText().toString());
            vetCambio.setText(Double.toString(val * aux));
        }
    }

    protected void convertirEurosDolar() {

        double val, aux = 1.1;

        if ("".equals(vetEuros.getText().toString())){
            Toast.makeText(MainActivity.this,"Ingrese Cantidad a Convertir.", Toast.LENGTH_SHORT).show();
            
        }
        else{
            val = Double.parseDouble(vetEuros.getText().toString());
            vetCambio.setText(Double.toString(val * aux));
        }
    }

    public void onClick(View v) {


        if (v == vbtnConvertir){
            if (vrbDolarEuros.isChecked()) {
                convertirDolarEuros();
            }
            if (vrbEurosDolar.isChecked()) {
                convertirEurosDolar();
            }
        }

        if (v == vrbDolarEuros){
            vrbEurosDolar.setChecked(false);
            vetEuros.setEnabled(false);
            vetDolar.setEnabled(true);
            vetEuros.setText("");
            vetDolar.setFocusable(true);
            vetCambio.setText("");
        }

        if (v == vrbEurosDolar){
            vrbDolarEuros.setChecked(false);
            vetDolar.setEnabled(false);
            vetEuros.setEnabled(true);
            vetDolar.setText("");
            vetEuros.setFocusable(true);
            vetCambio.setText("");
        }
    }

}
