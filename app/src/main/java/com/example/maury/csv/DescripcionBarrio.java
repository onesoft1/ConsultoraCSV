package com.example.maury.csv;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.multispinner.MultiSelectSpinner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    EditText contaminante, inclina, taagua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_barrio);
        //recuperar nombre del archivo
        archi = (TextView) findViewById(R.id.archivo);
        archi1 = getIntent().getExtras().getString("archivo");
        archi.setText(archi1);

        //Multi Spinner servicios Vacicos

        String[] array = {"None", "Luz", "Agua", "AlCantarillado", "Telefono", "Gas", "Transporte", "Alumbrado"};
        MultiSelectSpinner multiSelectSpinner = (MultiSelectSpinner) findViewById(R.id.spinnerserviciosvacicos);
        multiSelectSpinner.setItems(array);
        multiSelectSpinner.hasNoneOption(true);
        multiSelectSpinner.setSelection(new int[]{0});
        multiSelectSpinner.setListener(new MultiSelectSpinner.OnMultipleItemsSelectedListener() {
            @Override
            public void selectedIndices(List<Integer> indices) {

            }

            @Override
            public void selectedStrings(List<String> strings) {
                 datosllena(2,14,"");
                datosllena(4,14,"");
                datosllena(6,14,"");
                datosllena(8,14,"");
                datosllena(10,14,"");
                datosllena(12,14,"");
                datosllena(14,14,"");

                for(int i=0; i<strings.size();i++){
                    String valor= "Si";

                    String datos= strings.get(i);
                    if(datos=="Luz"){
                        //Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                        datosllena(2,14,valor);

                    }else{

                        if (datos=="Agua"){
                            // Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                            datosllena(4,14,valor);

                        }else {
                            if (datos=="AlCantarillado"){
                                // Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                                datosllena(6,14,valor);


                            }else{
                                if (datos=="Telefono"){
                                    // Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                                    datosllena(8,14,valor);


                                }else{
                                    if (datos=="Gas"){
                                        // Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                                        datosllena(10,14,valor);


                                    }else{
                                        if (datos=="Transporte"){
                                            // Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                                            datosllena(12,14,valor);


                                        }else {
                                            if (datos=="Alumbrado"){
                                                //Toast.makeText(getApplicationContext(), "Compo Seleccionado:" + datos, Toast.LENGTH_LONG).show();
                                                datosllena(14,14,"si");

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }



                    //Toast.makeText(getApplicationContext(), "Componentes Seleccionados:" + datos, Toast.LENGTH_LONG).show();
                }






               // Toast.makeText(getApplicationContext(), "Componentes Seleccionados:" + strings, Toast.LENGTH_LONG).show();
            }
        });




        //
        //Multi Spinner Documentos del Cliente

        String[] array1 = {"None", "Testimonio", "DD.RR.", "Catastro", "P.U. Suelo", "P. Contr.", "Inpuesto", "Alumbrado"};
        MultiSelectSpinner multiSelectSpinner1 = (MultiSelectSpinner) findViewById(R.id.spinnerdocumentacioncliente);
        multiSelectSpinner1.setItems(array);
        multiSelectSpinner1.hasNoneOption(true);
        multiSelectSpinner1.setSelection(new int[]{0});
        multiSelectSpinner1.setListener(new MultiSelectSpinner.OnMultipleItemsSelectedListener() {
            @Override
            public void selectedIndices(List<Integer> indices) {

            }

            @Override
            public void selectedStrings(List<String> strings) {
                Toast.makeText(getApplicationContext(), "Componentes Seleccionados:" + strings, Toast.LENGTH_LONG).show();
            }
        });

        //

//-------Spinner------


        // cargado de tipo
        tipo = (Spinner) findViewById(R.id.Tipo);


        // ArrayList<tipos> tipooo=new ArrayList<tipos>();

        String[] tipoo = {"Seleccione una Opcion", "Urbano", "Rural", "Suburbano", "Industrial"};
        ArrayAdapter<String> adaptertipo = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, tipoo);
        tipo.setAdapter(adaptertipo);
        tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();
                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(6, 9, seleccion);
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
        zona = (Spinner) findViewById(R.id.ActividadZona);
        String[] zonaa = {"Seleccione una Opcion", "Residencial", "Comercial", "Agrícola", "Industrial"};
        ArrayAdapter<String> adapterzona = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, zonaa);
        zona.setAdapter(adapterzona);
        zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();
                //menssaje(seleccion);
                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(6, 10, seleccion);
                        copySheet.addCell(label1);
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

        // cargado de descripcion calle
        calle = (Spinner) findViewById(R.id.DesCalle);
        String[] callee = {"Seleccione una Opcion", "Tierra", "Empedrado", "Asfalto", "Pavimento"};
        ArrayAdapter<String> adaptercalle = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, callee);
        calle.setAdapter(adaptercalle);
        calle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(6, 12, seleccion);
                        copySheet.addCell(label1);
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

        //

        // cargado de ocupado
        ocupado = (Spinner) findViewById(R.id.Ocupado);
        String[] ocupadoo = {"Seleccione una Opcion", "Propietario", "Inquilino en Alquiler", "Inquilinos en anticrético", "Sin ocupantes", "Empleados", "Parientes", "Solicitante"};
        ArrayAdapter<String> adapterocupado = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ocupadoo);
        ocupado.setAdapter(adapterocupado);
        ocupado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(6, 13, seleccion);
                        copySheet.addCell(label1);
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


        //

        // Cargado de muro norte
        muronorte = (Spinner) findViewById(R.id.MuroNorte);
        String[] murosnortee = {"Seleccione una Opcion", "Propios", "Vecinos", "Medianeros"};
        ArrayAdapter<String> adapternorte = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, murosnortee);
        muronorte.setAdapter(adapternorte);
        muronorte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(1, 15, seleccion);
                        copySheet.addCell(label1);
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

        //

        // Cargado de muro sud
        murosud = (Spinner) findViewById(R.id.MuroSud);
        String[] murosudd = {"Seleccione una Opcion", "Propios", "Vecinos", "Medianeros"};
        ArrayAdapter<String> adaptersud = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, murosudd);
        murosud.setAdapter(adaptersud);
        murosud.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(1, 16, seleccion);
                        copySheet.addCell(label1);
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

        //

        // Cargado de muro este
        muroeste = (Spinner) findViewById(R.id.MuroEste);
        String[] muroestee = {"Seleccione una Opcion", "Propios", "Vecinos", "Medianeros"};
        ArrayAdapter<String> adaptereste = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, muroestee);
        muroeste.setAdapter(adaptereste);
        muroeste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(1, 17, seleccion);
                        copySheet.addCell(label1);
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
        //

        // Cargado de muro oeste
        murooeste = (Spinner) findViewById(R.id.MuroOeste);
        String[] murooestee = {"Seleccione una Opcion", "Propios", "Vecinos", "Medianeros"};
        ArrayAdapter<String> adapteroeste = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, murooestee);
        murooeste.setAdapter(adapteroeste);
        murooeste.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(1, 18, seleccion);
                        copySheet.addCell(label1);
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

        //


        // Cargado de Ancho de Via
        anchovia = (Spinner) findViewById(R.id.AnchoVia);
        String[] anchoviaa = {"Seleccione una Opcion", "9", "12", "MAS DE 20"};
        ArrayAdapter<String> adaptervia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, anchoviaa);
        anchovia.setAdapter(adaptervia);
        anchovia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seleccion = adapterView.getItemAtPosition(i).toString();

                path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

                if (seleccion == "Seleccione una Opcion") {

                } else {
                    try {
                        Workbook wb = Workbook.getWorkbook(new File(path));
                        WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                        WritableSheet copySheet = copy.getSheet(0);
                        Label label1 = new Label(11, 16, seleccion);
                        copySheet.addCell(label1);
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
        //

        //------CheckBox-------
        //cordones
        cordones = (CheckBox) findViewById(R.id.Cordones);

        //-----EditTex------
        // contaminacion
        contaminante = (EditText) findViewById(R.id.contaminacion);
        inclina= (EditText) findViewById(R.id.inclinacion);
        taagua=(EditText) findViewById(R.id.tagus);
    }
    private void datosllena(int c, int r, String dato){
        try {
            Workbook wb = Workbook.getWorkbook(new File(path));
            WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
            WritableSheet copySheet=copy.getSheet(0);
            Label label1=new Label(c,r,dato);

            copySheet.addCell(label1);

            copy.write();
            copy.close();
            //Toast.makeText(getApplicationContext(), "dato llenado en:"+c+r+ dato, Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void menssaje(String a)
    {
        Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
    }

    public void siguiente(View view) {
        String nomArchivo=archi.getText().toString();
        validarcheckbox();
        contaminantes();
        inclinacion();
        Tagua();

        Intent i=new Intent(this,DescripcionConstruccion.class);
        i.putExtra("archivo",nomArchivo);
        startActivity(i);

    }

    private void Tagua(){
        String incli= taagua.getText().toString();

        if(incli!=""){
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                WritableSheet copySheet=copy.getSheet(0);
                Label label1=new Label(11,17,incli);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            menssaje("Debe llenar el Campo de Tanque de Agua");

        }
    }

    private void inclinacion(){
        String incli= inclina.getText().toString();

        if(incli!=""){
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                WritableSheet copySheet=copy.getSheet(0);
                Label label1=new Label(11,15,incli);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            menssaje("Debe llenar el Campo Inclinacion");

        }
    }

    private void contaminantes(){
        String conta= contaminante.getText().toString();

        if(conta!=""){
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
                WritableSheet copySheet=copy.getSheet(0);
                Label label1=new Label(6,11,conta);
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
            menssaje("Debe llenar el Campo Focos de Contaminacion");

        }

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
