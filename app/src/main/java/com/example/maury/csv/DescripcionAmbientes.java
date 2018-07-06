package com.example.maury.csv;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DescripcionAmbientes extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST_WRITE_EXTERNAL=1;

    private final String CARPETA_RAIZ="Csv/";
    String path;


    claseglobal datos;
    int horizontal;
    TextView archi, cons;
    String archi1, ambiente;
    EditText plantas,living1,comedores1, salas1, cocinas1, despensas1, dormitorios1, suites1, banos1, escritorios1, areas1, lavanderias1, cuartos1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_ambientes);
        path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";

        datos= (claseglobal)getApplicationContext();

        archi = (TextView) findViewById(R.id.archivo);
        archi1 = getIntent().getExtras().getString("archivo");
        archi.setText(archi1);

        cons=findViewById(R.id.descrip);
        ambiente =cons.getText().toString();

        cons.setText(ambiente+" "+datos.getContruccion());
        horizontal=datos.getContador();

        plantas= findViewById(R.id.planta);
// edit text
        living1=(EditText) findViewById(R.id.livings);
        comedores1=(EditText) findViewById(R.id.comedores);
        salas1=(EditText) findViewById(R.id.Salas);
        cocinas1=(EditText) findViewById(R.id.cocinas);
        despensas1=(EditText) findViewById(R.id.despensas);
        dormitorios1=(EditText) findViewById(R.id.dormitorios);
        suites1=(EditText) findViewById(R.id.suites);
        banos1=(EditText) findViewById(R.id.baños);
        escritorios1=(EditText) findViewById(R.id.escritorios);
        areas1=(EditText) findViewById(R.id.areas);
        lavanderias1=(EditText) findViewById(R.id.lavanderias);
        cuartos1=(EditText) findViewById(R.id.cuartos);



    }
    public void menssaje(String a)
    {
        Toast.makeText(this,a,Toast.LENGTH_SHORT).show();
    }

    public void siguiente(View view) {
        String nomArchivo=archi.getText().toString();
        datosllena(horizontal,46,plantas.getText().toString()+datos.getContruccion());
        Intent i=new Intent(this,CapturaImagen.class);
        i.putExtra("archivo",nomArchivo);
        startActivity(i);
        Living2();
        Comedores2();
        Salita();
        Cocinas2();
        Despensa();
        Dormitorio2();
        Suites2();
        Baño2();
        Escritorio2();
        Aereas();
        Lavanderiass();
        cuartos2();


    }

    private void datosllena(int c, int r, String dato){
        path = Environment.getExternalStorageDirectory() + File.separator + CARPETA_RAIZ + File.separator + archi1 + ".xls";
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
    // living1
       private void Living2() {
        String Livings = living1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (Livings != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 47, Livings);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de livings");

        }


       }
    //comedores1,
    private void Comedores2() {
        String comedoress = comedores1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (comedoress != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 48, comedoress);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de comedores");

        }


    }
    // salas1,
    private void Salita() {
        String salitaa = salas1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (salitaa != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 49, salitaa);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de salas");

        }


    }
    // cocinas1,
    private void Cocinas2() {
        String cocinass = cocinas1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (cocinass != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 50, cocinass);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de cocinas");

        }


    }
    // despensas1,
    private void Despensa() {
        String despencita = despensas1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (despencita != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 51, despencita);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de despensas");

        }


    }
    // dormitorios1,
    private void Dormitorio2() {
        String dormis = dormitorios1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (dormis != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 52, dormis);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de Dormitorios");

        }


    }
    // suites1,
    private void Suites2() {
        String suitis = suites1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (suitis != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 53, suitis);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de suite con baño privado");

        }


    }
    // banos1,
    private void Baño2() {
        String bañitoa = banos1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (bañitoa != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 54, bañitoa);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de Baños");

        }


    }
    // escritorios1,
    private void Escritorio2() {
        String escritorioss = escritorios1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (escritorioss != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 55, escritorioss);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de Escritorios");

        }


    }
    // areas1,
    private void Aereas() {
        String areass = areas1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (areass != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 56, areass);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de área de serv. con dormitorio y baños");

        }


    }
    // lavanderias1,
    private void Lavanderiass() {
        String lavanderita = lavanderias1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (lavanderita != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 57, lavanderita);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de Lavanderias");

        }


    }
    // cuartos1 ;
    private void cuartos2() {
        String cuartito = cuartos1.getText().toString();
        path= Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+archi1+".xls";
        if (cuartito != "") {
            try {
                Workbook wb = Workbook.getWorkbook(new File(path));
                WritableWorkbook copy = Workbook.createWorkbook(new File(path), wb);
                WritableSheet copySheet = copy.getSheet(0);
                Label label1 = new Label(1, 58, cuartito);

                copySheet.addCell(label1);

                copy.write();
                copy.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            menssaje("Debe llenar el numero de Cuartos");

        }


    }


}
