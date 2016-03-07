package com.zapata.yerson.punto4;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner lista;
    String [] ciudades={"Medellin","Itagui","Envigado","Sabaneta","SantaFe","Bello","Bogota"};
    private String ciudad,sexo="Masculino",hobbie="Ajedrez";
    private EditText eUser,ePass,eRpass,eEmail,eFecha;
    private RadioGroup sex,hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=(Spinner)findViewById(R.id.lugar);
        eUser = (EditText) findViewById(R.id.usuario);
        ePass = (EditText) findViewById(R.id.pass);
        eRpass = (EditText)findViewById(R.id.pass2);
        eEmail = (EditText) findViewById(R.id.eMail);
        eFecha=(EditText) findViewById(R.id.fecha);
        sex= (RadioGroup) findViewById(R.id.sex);
        hobbies=(RadioGroup) findViewById(R.id.hobbies);


        hobbies.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.h1:
                        hobbie="Ajedrez";
                        break;
                    case R.id.h2:
                        hobbie="Nadar";
                        break;
                    case R.id.h3:
                        hobbie="Cantar";
                        break;
                    case R.id.h4:
                        hobbie="Caminar";
                        break;

                }
            }
        });

sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.male:
                sexo="Masculino";
                break;
            case R.id.female:
                sexo="Femenino";
                break;
        }
    }
});

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,ciudades );
        lista.setAdapter(adaptador);

        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        ciudad = "Medellin";
                        break;
                    case 1:
                        ciudad = "Itagui";
                        break;
                    case 2:
                        ciudad = "Envigado";
                        break;
                    case 3:
                        ciudad = "Sabaneta";
                        break;
                    case 4:
                        ciudad = "Santafe";
                        break;
                    case 5:
                        ciudad = "Bello";
                        break;
                    case 6:
                        ciudad = "Bogota";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


    }

    public void bAceptar (View v) {
        String name,pass1,pass2,email,datosfull,fecha;
        int bandera=0;

        name= String.valueOf(eUser.getText());
        if (name.equals("")){
            bandera=bandera+1;
            eUser.setHint("Campo Obligatorio");
        }

        pass1= String.valueOf(ePass.getText());
        if (pass1.equals("")){
            bandera=bandera+1;
            ePass.setHint("Campo Obligatorio");
        }

        pass2= String.valueOf(eRpass.getText());
        if (pass2.equals("")){
            bandera=bandera+1;
            eRpass.setHint("Campo Obligatorio");
        }
        if (pass1.equals(pass2)){

        }else{
            ePass.setText("");
            ePass.setHint("Reingresar");
            eRpass.setHint("Reingresar");
            eRpass.setText("");
            bandera=bandera+2;
        }
        email =String.valueOf(eEmail.getText());
        if (email.equals("")){
            bandera=bandera+1;
            eEmail.setHint("Campo Obligatorio");
        }
        fecha=String.valueOf(eFecha.getText());
        if (fecha.equals("")){
            bandera=bandera+1;
            eFecha.setHint("Campo Obligatorio");
        }


        if (bandera == 0) {
            datosfull="Nombre: \t"+name+"\nContraseña: \t"+pass1+"\nCorreo: \t"+email+"\n" +
                    "sexo: \t"+sexo+"\nNacio el: \t"+fecha+"\nNacio en: \t"+ciudad+"\nHobbie: \t"+hobbie;
            Toast todo = Toast.makeText(getApplicationContext(), datosfull, Toast.LENGTH_LONG);
            todo.show();
        } else {
            Toast todo = Toast.makeText(getApplicationContext(), ("Error en " +bandera+" campos"), Toast.LENGTH_LONG);
            todo.show();
        }
    }

    public void onStart(){
        super.onStart();
        EditText txtDate =(EditText)findViewById(R.id.fecha);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    DateDialog dialog =new  DateDialog(v);
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    dialog.show(ft,"DatePicker");
                }
            }
        });
    }

}
