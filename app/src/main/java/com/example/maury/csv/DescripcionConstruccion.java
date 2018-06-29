package com.example.maury.csv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
//import android.widget.Toast;

import java.io.File;
//import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DescripcionConstruccion extends AppCompatActivity  {
    private static final int MY_PERMISSION_REQUEST_WRITE_EXTERNAL=1;
    private final String CARPETA_RAIZ="Csv/";
    String path;
    TextView archi;
    String archi1;
    Spinner array, arrays1, array2, arrays3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_construccion);
        archi= (TextView) findViewById(R.id.archivo);
        archi1=getIntent().getExtras().getString("archivo");
        archi.setText(archi1);
        //
        array = (Spinner) findViewById(R.id.cimiento);
        String[] array1 = {"None", "Losa Radier", "Hormigón Armado", "Hormigón Ciclópeo", "Piedra", "Ladrillo", "Piedra y Barro"};
        ArrayAdapter<String> Adapterconstru= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,array1);
        array.setAdapter(Adapterconstru);
        array.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion=adapterView.getItemAtPosition(i).toString();
                path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";

                if(seleccion=="Seleccione una Opcion"){

                }
                else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                        WritableSheet copySheet=copy.getSheet(0);
                        Label label1=new Label(1,23,seleccion);
                        copySheet.addCell(label1);
                        copy.write();
                        copy.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        arrays1=(Spinner) findViewById(R.id.estructura);
        String[] arrays = {"None", "Hormigón Armado", "mixta de H°A° y muros portantes", "muros portantes con encadenado", "muros portantes sin encadenado", "metálica", "madera"};
        ArrayAdapter<String> adapterzona= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays);
        arrays1.setAdapter(adapterzona);
        arrays1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion=adapterView.getItemAtPosition(i).toString();
                path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";

                if(seleccion=="Seleccione una Opcion"){

                }
                else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                        WritableSheet copySheet=copy.getSheet(0);
                        Label label1=new Label(1,24,seleccion);
                        copySheet.addCell(label1);
                        copy.write();
                        copy.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
/////
        array2=(Spinner) findViewById(R.id.cubierta);
        String[] arrays1 = {"None", "Losa llena de H° A°", "Losa alivianada","Shingle", "Teja cerámica", "Placas de fibrocemento", "Teja de cemento,", "Calamina","placas de cartón"};
        ArrayAdapter<String> adapterz= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays1);
        array2.setAdapter(adapterz);
        array2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion=adapterView.getItemAtPosition(i).toString();
                path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";

                if(seleccion=="Seleccione una Opcion"){

                }
                else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                        WritableSheet copySheet=copy.getSheet(0);
                        Label label1=new Label(1,25,seleccion);
                        copySheet.addCell(label1);
                        copy.write();
                        copy.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    public void siguiente(View view) {
        String nomArchivo=archi.getText().toString();
        Intent i=new Intent(this,CapturaImagen.class);
        i.putExtra("archivo",nomArchivo);
        startActivity(i);
    }


}
