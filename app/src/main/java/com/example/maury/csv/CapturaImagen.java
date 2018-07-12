package com.example.maury.csv;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class CapturaImagen extends AppCompatActivity {

    claseglobal datos;

    private final String CARPETA_RAIZ="Csv/";
    private final String CARPETA_RAIZZ="Csv/";

    private  String RUTA_IMAGEN;

    final int COD_SELECCIONA=10;
    final int COD_FOTO=20;
    int codigo=0;
    int celda=61;
    Button botonCargar;
    ImageView imagen;
    String path,path1;
    TextView archi;
    String archi1,construccion,planta;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura_imagen);
        datos= (claseglobal)getApplicationContext();

        construccion="Construccion "+datos.getContruccion();
        planta="Planta "+datos.getPlanta();

        archi= (TextView) findViewById(R.id.archivo);

        archi1=getIntent().getExtras().getString("archivo");
        archi.setText(archi1);

        RUTA_IMAGEN=CARPETA_RAIZ+archi1;

        imagen= (ImageView) findViewById(R.id.imagemId);
        botonCargar= (Button) findViewById(R.id.btnCargarImg);

        if(validaPermisos()){
            botonCargar.setEnabled(true);
        }else{
            botonCargar.setEnabled(false);
        }
    }


    private boolean validaPermisos() {

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if((checkSelfPermission(CAMERA)==PackageManager.PERMISSION_GRANTED)&&
                (checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
            return true;
        }

        if((shouldShowRequestPermissionRationale(CAMERA)) ||
                (shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length==2 && grantResults[0]==PackageManager.PERMISSION_GRANTED
                    && grantResults[1]==PackageManager.PERMISSION_GRANTED){
                botonCargar.setEnabled(true);
            }else{
                solicitarPermisosManual();
            }
        }

    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(CapturaImagen.this);
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri=Uri.fromParts("package",getPackageName(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(CapturaImagen.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.show();
    }

    public void onclick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {

        final CharSequence[] opciones={"Tomar Foto","Cancelar"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(CapturaImagen.this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){
                    RUTA_IMAGEN=CARPETA_RAIZ+archi1;
                    tomarFotografia();
                }else{
                    if (opciones[i].equals("Cargar Imagen")){
                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent,"Seleccione la Aplicación"),COD_SELECCIONA);
                    }else{
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();

    }

    private void tomarFotografia() {

        //datos.setFotos();

        File fileImagen=new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
        boolean isCreada=fileImagen.exists();
        String nombreImagen="";
        String nombreImagen1="";
        codigo=codigo+1;
        if(isCreada==false){
            isCreada=fileImagen.mkdirs();
        }

        if(isCreada==true){
            RUTA_IMAGEN=RUTA_IMAGEN+File.separator+construccion;
            File fileImagencon=new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
            boolean isCreadacon=fileImagencon.exists();
            //String nombreImagencon="";
            if(isCreadacon==false){
                isCreadacon=fileImagencon.mkdirs();
            }
            if(isCreadacon==true){
                RUTA_IMAGEN=RUTA_IMAGEN+File.separator+planta;
                File fileImagenplan=new File(Environment.getExternalStorageDirectory(),RUTA_IMAGEN);
                boolean isCreadaplan=fileImagenplan.exists();
                if(isCreadaplan==false){
                    isCreadaplan=fileImagenplan.mkdirs();
                }
                if(isCreadaplan==true){
                    nombreImagen=(archi1+construccion+planta+codigo)+".jpg";
                }


            }


            //nombreImagen1=archi1+codigo;



        }


        path=Environment.getExternalStorageDirectory()+
                File.separator+RUTA_IMAGEN+File.separator+nombreImagen;

        File imagen=new File(path);

        Intent intent=null;
        intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ////
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            String authorities=getApplicationContext().getPackageName()+".provider";
            Uri imageUri=FileProvider.getUriForFile(this,authorities,imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        }else
        {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent,COD_FOTO);

        ////
        datosfoto(nombreImagen);



    }
    private void datosfoto(String nombreIma)
    {
        //Datos de las fotos almacenar
        //String nomArchivo=NomArchivo.getText().toString();
        path1=Environment.getExternalStorageDirectory()+
                File.separator+CARPETA_RAIZZ+File.separator+archi1+".xls";

        try {

            Workbook wb = Workbook.getWorkbook(new File(path1));
            WritableWorkbook copy=Workbook.createWorkbook(new File(path1),wb);
            WritableSheet copySheet=copy.getSheet(0);

            Label label2=new Label(0,celda,nombreIma);
            //Label label1=new Label(2,52,"Bien");
            // Label label3=new Label(1,4,"Todo Bien");

            copySheet.addCell(label2);
            //copySheet.addCell(label1);
            //copySheet.addCell(label3);
            copy.write();
            copy.close();
            celda=celda+1;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){

            switch (requestCode){
                case COD_SELECCIONA:
                    Uri miPath=data.getData();
                    imagen.setImageURI(miPath);
                    break;

                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento","Path: "+path);
                                }
                            });

                    Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);

                    break;
            }


        }
    }

    public void nuevaplanta(View view) {

        String nomArchivo=archi.getText().toString();
        Intent i=new Intent(this,DescripcionAmbientes.class);
        i.putExtra("archivo",nomArchivo);
        datos.setContadescrip(datos.getContadescrip()+2);
        //obtener.setContruccion(con);
        //i.putExtra("costruccion", (Parcelable) construcio);
        startActivity(i);

    }

    public void nuevaconstruccion(View view) {
        String nomArchivo=archi.getText().toString();
        Intent i=new Intent(this,DescripcionConstruccion.class);
        i.putExtra("archivo",nomArchivo);
        datos.setContadescrip(datos.getContadescrip()+2);
        //obtener.setContruccion(con);
        //i.putExtra("costruccion", (Parcelable) construcio);
        startActivity(i);
    }

    public void terminado(View view) {
    }
}
