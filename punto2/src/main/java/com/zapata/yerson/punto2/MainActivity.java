package com.zapata.yerson.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText operador1, operador2;
    private TextView tResultado;
    private RadioGroup operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operador1 = (EditText) findViewById(R.id.operador1);
        operador2 = (EditText) findViewById(R.id.operador2);
        tResultado = (TextView) findViewById(R.id.tResultado);
        operacion = (RadioGroup) findViewById(R.id.operacion);
    }

    public void operar(View v) {

        float valor1 = Integer.parseInt(operador1.getText().toString());
        float valor2 = Integer.parseInt(operador2.getText().toString());
        float total = 0;

        switch (operacion.getCheckedRadioButtonId()) {
            case R.id.suma:

                total = valor1 + valor2;
                break;
            case R.id.resta:

                total = valor1 - valor2;
                break;
            case R.id.multiplicacion:

                total = valor1 * valor2;
                break;
            case R.id.division:

                total = valor1 / valor2;
                break;
        }
        tResultado.setText("Resultado: " + total);


    }
}
