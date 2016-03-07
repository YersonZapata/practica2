package com.zapata.yerson.punto3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText dimension1,dimension2;
    private TextView tResultado,tDimension1,tDimension2;
    private RadioGroup operacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dimension1 = (EditText) findViewById(R.id.eDimension1);
        dimension2 = (EditText) findViewById(R.id.eDimension2);

        tDimension1=(TextView) findViewById(R.id.tEdit1);
        tDimension2=(TextView) findViewById(R.id.tEdit2);
        tResultado = (TextView) findViewById(R.id.tResultado);
        operacion = (RadioGroup) findViewById(R.id.operacion);

        dimension1.setText("0");
        dimension2.setText("0");
        tDimension1.setText("Lado: ");
        tDimension2.setText("");
        dimension1.setEnabled(true);
        dimension2.setEnabled(false);


        operacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //find with radioButton

                switch (checkedId) {

                    case R.id.rCuadrado:
                        tDimension1.setText("Lado: ");
                        tDimension2.setText("");
                        dimension1.setEnabled(true);
                        dimension2.setEnabled(false);


                        break;

                    case R.id.rTriangulo:
                        tDimension1.setText("Base: ");
                        tDimension2.setText("Altura: ");
                        dimension1.setEnabled(true);
                        dimension2.setEnabled(true);
                        tDimension2.setEnabled(true);
                        break;

                    case R.id.rRectangulo:
                        tDimension1.setText("Lado1: ");
                        tDimension2.setText("Lado2: ");
                        dimension1.setEnabled(true);
                        dimension2.setEnabled(true);
                        tDimension2.setEnabled(true);
                        break;

                    case R.id.rCirculo:
                        tDimension1.setText("Radio: ");
                        tDimension2.setText("");
                        dimension1.setEnabled(true);
                        dimension2.setEnabled(false);

                        break;
                }
            }
        });
    }



    public void operar(View v) {

      //  float valor1 = Integer.parseInt(operador1.getText().toString());
      //  float valor2 = Integer.parseInt(operador2.getText().toString());
        float area = 0,valorLado=0,valorBase=0,valorAltura=0,valorLado1=0,valorLado2=0,valorRadio=0;

        switch (operacion.getCheckedRadioButtonId()) {
            case R.id.rCuadrado:
                valorLado = Integer.parseInt(dimension1.getText().toString());

                area = valorLado * valorLado;
                break;
            case R.id.rTriangulo:
                 valorBase  = Integer.parseInt(dimension1.getText().toString());
                 valorAltura = Integer.parseInt(dimension2.getText().toString());
                area = (valorBase * valorAltura)/(float)2;
                break;
            case R.id.rRectangulo:
                 valorLado1 = Integer.parseInt(dimension1.getText().toString());
                 valorLado2 = Integer.parseInt(dimension2.getText().toString());
                area = valorLado1 * valorLado2;

                break;
            case R.id.rCirculo:
                 valorRadio = Integer.parseInt(dimension1.getText().toString());
                area = (valorRadio*valorRadio)*(float)Math.PI;
                break;
        }
        tResultado.setText(" " + area);


    }
}
