package com.example.maury.csv;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DescripcionBarrio extends AppCompatActivity {
    //Permisos de carpetas
    private static final int MY_PERMISSION_REQUEST_WRITE_EXTERNAL=1;

    private final String CARPETA_RAIZ="Csv/";
    String path;
    //



    TextView archi;

    String archi1;
    Spinner spinner,tipo,zona,calle,ocupado,muronorte,murosud,anchovia,muroeste,murooeste;



    CheckBox cordones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_barrio);
        //recuperar nombre del archivo
        archi=(TextView) findViewById(R.id.archivo);
        archi1=getIntent().getExtras().getString("archivo");
        archi.setText(archi1);






        // cargado de tipo
        tipo=(Spinner) findViewById(R.id.Tipo);





       // ArrayList<tipos> tipooo=new ArrayList<tipos>();

        String [] tipoo={"Seleccione una Opcion","Urbano","Rural","Suburbano","Industrial"};
        ArrayAdapter<String> adaptertipo= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,tipoo);
        tipo.setAdapter(adaptertipo);
        tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion=adapterView.getItemAtPosition(i).toString();
                path= Environment.getExternalStorageDirectory()+
                        File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";

                if(seleccion=="Seleccione una Opcion"){

                }
                else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                        WritableSheet copySheet=copy.getSheet(0);
                       Label label1=new Label(6,9,seleccion);
                       // Label label2=new Label(1,6,datee);
                       // Label label3=new Label(1,4,"Todo Bien");
                       copySheet.addCell(label1);
                       // copySheet.addCell(label2);
                       // copySheet.addCell(label3);
                        copy.write();
                        copy.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                menssaje(seleccion);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // cargado de Actividad Zona
        zona=(Spinner) findViewById(R.id.ActividadZona);
        String [] zonaa={"Seleccione una Opcion","Residencial","Comercial","Agrícola","Industrial"};
        ArrayAdapter<String> adapterzona= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,zonaa);
        zona.setAdapter(adapterzona);
        zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion=adapterView.getItemAtPosition(i).toString();
                menssaje(seleccion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // cargado de descripcion calle
        calle=(Spinner) findViewById(R.id.DesCalle);
        String [] callee={"Seleccione una Opcion","Tierra","Empedrado","Asfalto","Pavimento"};
        ArrayAdapter<String> adaptercalle= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,callee);
        calle.setAdapter(adaptercalle);

        // cargado de ocupado
        ocupado=(Spinner) findViewById(R.id.Ocupado);
        String [] ocupadoo={"Seleccione una Opcion","Propietario","Inquilino en Alquiler","Inquilinos en anticrético","Sin ocupantes","Empleados","Parientes","Solicitante"};
        ArrayAdapter<String> adapterocupado= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,ocupadoo);
        ocupado.setAdapter(adapterocupado);

        // Cargado de muro norte
        muronorte=(Spinner) findViewById(R.id.MuroNorte);
        String [] murosnortee={"Seleccione una Opcion","Propios","Vecinos","Medianeros"};
        ArrayAdapter<String> adapternorte= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,murosnortee);
        muronorte.setAdapter(adapternorte);

        // Cargado de muro sud
        murosud=(Spinner) findViewById(R.id.MuroSud);
        String [] murosudd={"Seleccione una Opcion","Propios","Vecinos","Medianeros"};
        ArrayAdapter<String> adaptersud= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,murosudd);
        murosud.setAdapter(adaptersud);

        // Cargado de muro este
        muroeste=(Spinner) findViewById(R.id.MuroEste);
        String [] muroestee={"Seleccione una Opcion","Propios","Vecinos","Medianeros"};
        ArrayAdapter<String> adaptereste= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,muroestee);
        muroeste.setAdapter(adaptereste);

        // Cargado de muro oeste
        murooeste=(Spinner) findViewById(R.id.MuroOeste);
        String [] murooestee={"Seleccione una Opcion","Propios","Vecinos","Medianeros"};
        ArrayAdapter<String> adapteroeste= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,murooestee);
        murooeste.setAdapter(adapteroeste);


        // Cargado de Ancho de Via
        anchovia=(Spinner) findViewById(R.id.AnchoVia);
        String [] anchoviaa={"Seleccione una Opcion","9","12","MAS DE 20"};
        ArrayAdapter<String> adaptervia= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,anchoviaa);
        anchovia.setAdapter(adaptervia);

        //------CheckBox-------
        //cordones
        cordones= (CheckBox) findViewById(R.id.Cordones);




    }

    public void menssaje(String a)
    {
        Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
    }

    public void siguiente(View view) {
        String nomArchivo=archi.getText().toString();
        validarcheckbox();

        Intent i=new Intent(this,DescripcionConstruccion.class);
        i.putExtra("archivo",nomArchivo);
        startActivity(i);

    }

    private void validarcheckbox() {
            if(cordones.isChecked()==true){
                try {
                    Workbook wb = Workbook.getWorkbook(new File(path));
                    WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                    WritableSheet copySheet=copy.getSheet(0);
                    Label label1=new Label(16,12,"Si");
                    // Label label2=new Label(1,6,datee);
                    // Label label3=new Label(1,4,"Todo Bien");
                    copySheet.addCell(label1);
                    // copySheet.addCell(label2);
                    // copySheet.addCell(label3);
                    copy.write();
                    copy.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                try {
                    Workbook wb = Workbook.getWorkbook(new File(path));
                    WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                    WritableSheet copySheet=copy.getSheet(0);
                    Label label1=new Label(16,12," ");
                    // Label label2=new Label(1,6,datee);
                    // Label label3=new Label(1,4,"Todo Bien");
                    copySheet.addCell(label1);
                    // copySheet.addCell(label2);
                    // copySheet.addCell(label3);
                    copy.write();
                    copy.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }


}
