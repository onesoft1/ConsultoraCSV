package com.example.maury.csv;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    EditText plantas;

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

    }

    public void siguiente(View view) {

        datosllena(horizontal,46,plantas.getText().toString()+datos.getContruccion());



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
}
