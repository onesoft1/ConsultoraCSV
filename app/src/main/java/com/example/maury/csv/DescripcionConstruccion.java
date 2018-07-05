package com.example.maury.csv;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;

import java.io.File;
//import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DescripcionConstruccion extends AppCompatActivity  {
  //  private static final int MY_PERMISSION_REQUEST_WRITE_EXTERNAL=1;
    private final String CARPETA_RAIZ="Csv/";
    claseglobal obtener;
    String path;
    TextView archi;
    String archi1;
    Spinner array, arrays1, array2, arrays3,arrays4,arrays5,arrays6, arrays7, arrays8, arrays9, arrays10, arrays11, arrays12, arrays13, arrays14, arrays15, arrays16, arrays17,arrays18,arrays19;
    int conta;
    EditText avanceObra, numePlanta, altillo, terrazas, construcio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_construccion);
        obtener=(claseglobal)getApplicationContext();


        conta=obtener.getContador();

        //avance de obra////HASTA AQUIIIIIII********
        avanceObra= (EditText) findViewById(R.id.avanceobra);
        //numero de plantas
        numePlanta =(EditText) findViewById(R.id.numeplantas);
        construcio= (EditText) findViewById(R.id.construc);
        //altillo
        altillo=(EditText) findViewById(R.id.altillo);
        //terrazas
        terrazas=(EditText) findViewById(R.id.terrazas);
        archi= (TextView) findViewById(R.id.archivo);
        archi1=getIntent().getExtras().getString("archivo");
        archi.setText(archi1);
        //CIMIENTOS
        array = (Spinner) findViewById(R.id.cimiento);
        String[] array1 = {"Seleccione una Opcion", "Losa Radier", "Hormigón Armado", "Hormigón Ciclópeo", "Piedra", "Ladrillo", "Piedra y Barro"};
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
                        Label label1=new Label(conta,23,seleccion);
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
        //estructura
        arrays1=(Spinner) findViewById(R.id.estructura);
        String[] arrays = {"Seleccione una Opcion", "Hormigón Armado", "mixta de H°A° y muros portantes", "muros portantes con encadenado", "muros portantes sin encadenado", "metálica", "madera"};
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
                        Label label1=new Label(conta,24,seleccion);
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
/////Cubierta//////
        array2=(Spinner) findViewById(R.id.cubierta);
        String[] arrays1 = {"Seleccione una Opcion", "Losa llena de H° A°", "Losa alivianada","Shingle", "Teja cerámica", "Placas de fibrocemento", "Teja de cemento,", "Calamina","placas de cartón"};
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
                        Label label1=new Label(conta,25,seleccion);
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
//cielos/////
        arrays3=(Spinner) findViewById(R.id.cielos);
        String[] arrays2 = {"Seleccione una Opcion", "Con cielos falsos plafoneados", "Con cielos falsos","Con cielos rasos a viga vista", "Con cielos rasos", "Con tumbado", "Sin cielos rasos ni falsos"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays2);
        arrays3.setAdapter(adapter);
        arrays3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,26,seleccion);
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
    ///Muros//
        arrays4=(Spinner) findViewById(R.id.muros);
        String[] arrays3 = {"Seleccione una Opcion", "De hormigón armado", "De piedra cortada","De piel de vidrio", "De madera", "De ladrillo", "De paneles aglomerados", "De bloques pref. asbesto cemento", "De bloques de cemento", "De adobe"};
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays3);
        arrays4.setAdapter(adapter1);
        arrays4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,27,seleccion);
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
        // pisos ///
        arrays5=(Spinner) findViewById(R.id.pisos);
        String[] arrays4 = {"Seleccione una Opcion", "Tierra", "Contrapisos de Cemento","Ladrillo", "Cemento", "Mosaico", "Vinilo", "Alfombra de alto trafico", "Alfombra", "Tapizon,", "Cerámica", "Parquet", "Flotante", "Granito", "Mármol", "Porcelanato", "Machihembre"};
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays4);
        arrays5.setAdapter(adapter2);
        arrays5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,28,seleccion);
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
        //muros interiores
        arrays6=(Spinner) findViewById(R.id.murosinteriores);
        String[] arrays5 = {"Seleccione una Opcion", "Sin enlucir", "Enlucidos sin pintar","Enlucidos y pintados", "Empapelados"};
        ArrayAdapter<String> adapter3= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays5);
        arrays6.setAdapter(adapter3);
        arrays6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,29,seleccion);
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
        //muros exteriores
        arrays7=(Spinner) findViewById(R.id.murosexteriores);
        String[] arrays6 = {"Seleccione una Opcion", "Sin revoque", "Revocados","Revocados y pintados", "A ladrillo visto", "Revestidos parcialmente con piedra Tarija", "Revestidos parcialmente con piedra laja", "Revestidos parcialmente con mármol bruto"};
        ArrayAdapter<String> adapter4= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays6);
        arrays7.setAdapter(adapter4);
        arrays7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,30,seleccion);
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
        //carpinterias de puertas
        arrays8=(Spinner) findViewById(R.id.carpinteriapuertas);
        String[] arrays7 = {"Seleccione una Opcion", "Madera ", "Placas con estructura de madera","Vidrio", "Aluminio", "Metálica  de primera", "Metálica  de segunda"};
        ArrayAdapter<String> adapter5= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays7);
        arrays8.setAdapter(adapter5);
        arrays8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,31,seleccion);
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
        //carpinterias ventanas
        arrays9=(Spinner) findViewById(R.id.carpinteriavetanas);
        String[] arrays8= {"Seleccione una Opcion", "madera ", "aluminio ","metálica"};
        ArrayAdapter<String> adapter6= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays8);
        arrays9.setAdapter(adapter6);
        arrays9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,32,seleccion);
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
        //baños interiores******
        arrays10=(Spinner) findViewById(R.id.bañosinteriores);
        String[] arrays9= {"Seleccione una Opcion", "baños revocados ", "baños con revestimiento de cerámica ","baños con revestimiento de azulejos","baños con revestimiento de porcelanato"};
        ArrayAdapter<String> adapter7= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays9);
        arrays10.setAdapter(adapter7);
        arrays10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,33,seleccion);
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
        //mesones
        arrays11=(Spinner) findViewById(R.id.mesones);
        String[] arrays10= {"Seleccione una Opcion", "azulejos", "cerámica nacional ","cerámica importada ","granito","mármol","porcelanato"};
        ArrayAdapter<String> adapter8= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays10);
        arrays11.setAdapter(adapter8);
        arrays11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,34,seleccion);
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
        //cajoneria
        arrays12=(Spinner) findViewById(R.id.cajoneria);
        String[] arrays11= {"Seleccione una Opcion", "madera,  alta y baja cocina ", "melamina,  alta y baja cocina ","aluminio,  alta y baja cocina ", "madera, baja cocina ", "melamina, baja cocina ","aluminio, baja cocina", "madera, baja Baño  ", "melamina, baja Baño","aluminio, baja Baño"};
        ArrayAdapter<String> adapter9= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays11);
        arrays12.setAdapter(adapter9);
        arrays12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,35,seleccion);
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
        //roperos empotrados
        arrays13=(Spinner) findViewById(R.id.roperosempotrados);
        String[] arrays12= {"Seleccione una Opcion", "roperos empotrados en todos los dormitorios  ", "roperos empotrados solo en algunos dormitorios"};
        ArrayAdapter<String> adapter10= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays12);
        arrays13.setAdapter(adapter10);
        arrays13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,36,seleccion);
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
        //tinas
        arrays14=(Spinner) findViewById(R.id.tinas);
        String[] arrays13= {"Seleccione una Opcion", "Normales  ", "Hidromasajes  ","Jacuzzi "};
        ArrayAdapter<String> adapter11= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays13);
        arrays14.setAdapter(adapter11);
        arrays14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,37,seleccion);
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
        //molduras
        arrays15=(Spinner) findViewById(R.id.molduras);
        String[] arrays14= {"Seleccione una Opcion", "Molduras dec. de yeso en todos los ambientes ", "Molduras dec. solo en áreas sociales "};
        ArrayAdapter<String> adapter12= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays14);
        arrays15.setAdapter(adapter12);
        arrays15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,38,seleccion);
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
        //estado de conservacion
        arrays16=(Spinner) findViewById(R.id.estadoconservacion);
        String[] arrays15= {"Seleccione una Opcion", "Malo", "Bueno","Muy bueno","Excelente"};
        ArrayAdapter<String> adapter13= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays15);
        arrays16.setAdapter(adapter13);
        arrays16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,39,seleccion);
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
        //tipo de construccion
        arrays17=(Spinner) findViewById(R.id.tipoconstruccion);
        String[] arrays16= {"Seleccione una Opcion", "madera ", "aluminio ","metálica"};
        ArrayAdapter<String> adapter14= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, arrays16);
        arrays17.setAdapter(adapter14);
        arrays17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                        Label label1=new Label(conta,40,seleccion);
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
    public void menssaje(String a)
    {
        Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
    }
    public void siguiente(View view) {

        String con = construcio.getText().toString();
        String val="";
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (con.equals(val)) {
            menssaje("Debe Colocar una letra a la construccion");

        } else {

            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 22, con);

                copySheet.addCell(label1);

                copy.write();
                copy.close();
                avanceObra();
                numeroPlantas();
                terrazass();
                altillos();



                String nomArchivo=archi.getText().toString();
                Intent i=new Intent(this,DescripcionAmbientes.class);
                i.putExtra("archivo",nomArchivo);
                obtener.setContruccion(con);
                //i.putExtra("costruccion", (Parcelable) construcio);
                startActivity(i);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }



    private void avanceObra() {
        String avanceobra = avanceObra.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (avanceobra != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(conta, 41, avanceobra);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el % de avance de obra");

        }
    }
       // numePlanta =(EditText) findViewById(R.id.numeplantas);
        private void numeroPlantas() {
            String plantas = numePlanta.getText().toString();
            path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
            if (plantas != "") {
                try {
                    Workbook wb = Workbook.getWorkbook(new File(path));
                    WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                    WritableSheet copySheet = copy.getSheet(0);
                    Label label1 = new Label(conta, 42, plantas);

                    copySheet.addCell(label1);

                    copy.write();
                    copy.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                menssaje("Debe llenar el numero de plantas");

            }

        }
        // altillo=(EditText) findViewById(R.id.altillo);
        private void altillos() {
            String altill = altillo.getText().toString();
            path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
            if (altill != "") {
                try {
                    Workbook wb = Workbook.getWorkbook(new File(path));
                    WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                    WritableSheet copySheet = copy.getSheet(0);
                    Label label1 = new Label(conta, 43, altill);

                    copySheet.addCell(label1);

                    copy.write();
                    copy.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                menssaje("Debe llenar el numero de altilos");

            }

        }
        //terrazas=(EditText) findViewById(R.id.terrazas);
        private void terrazass() {
            String terracita = terrazas.getText().toString();
            path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
            if (terracita != "") {
                try {
                    Workbook wb = Workbook.getWorkbook(new File(path));
                    WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                    WritableSheet copySheet = copy.getSheet(0);
                    Label label1 = new Label(conta, 44, terracita);

                    copySheet.addCell(label1);

                    copy.write();
                    copy.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                menssaje("Debe llenar el numero de terrazas");

            }

        }


}
