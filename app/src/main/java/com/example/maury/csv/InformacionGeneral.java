package com.example.maury.csv;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class InformacionGeneral extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_WRITE_EXTERNAL=1;

    private final String CARPETA_RAIZ="Csv";
    String path;
    Date date;


    private EditText NomSolicitante, NomArchivo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_general);

        NomArchivo=(EditText) findViewById(R.id.nomarchivo);


        claseglobal iniciar=(claseglobal)getApplicationContext();
        iniciar.setContador(1);
        claseglobal iniciardescrip=(claseglobal)getApplicationContext();
        iniciardescrip.setContadescrip(1);

        //Calendar c= Calendar.getInstance();

       // NomSolicitante =(EditText) findViewById(R.id.nombresolicitante);

        checkPermission();
    }

    private void checkPermission() {
        if(ContextCompat.checkSelfPermission(InformacionGeneral.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(InformacionGeneral.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                // explicacion el uso del permiso
            }else{
                ActivityCompat.requestPermissions(InformacionGeneral.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST_WRITE_EXTERNAL);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSION_REQUEST_WRITE_EXTERNAL:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //Todo Bien
                   // Toast.makeText(this, "Acceso consedido al los Archivos").show();

                }else{
                    // el problema
                }
                return;

        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void siguiente(View view) {

       // ZoneId zona=ZoneId.systemDefault();
        date= new Date();

        String datee= new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String nomArchivo=NomArchivo.getText().toString();

        path=Environment.getExternalStorageDirectory()+
                File.separator+CARPETA_RAIZ+File.separator+nomArchivo+".xls";


        //File file= new File("/sdcard/"+nomArchivo+".xls");
        File file= new File(path);
        if (!file.exists())
        {
            Toast.makeText(this,"El Archivo  "+nomArchivo+"  No existe en el directorio",Toast.LENGTH_SHORT).show();
            //Date date= Date.from(LocalDate.now().atStartOfDay(zona).toInstant());
            Toast.makeText(this, "La hora es: "+date.getHours()+":"+date.getMinutes(),Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "La Fecha es: "+datee,Toast.LENGTH_SHORT).show();

            NomArchivo.setText("");
            //createExcel();
        }
        else{
           writengExcel();
            Intent i=new Intent(this,DescripcionBarrio.class);
            i.putExtra("archivo",nomArchivo);
            startActivity(i);
        }






    }

    private void writengExcel() {
        String datee= new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        String nomArchivo=NomArchivo.getText().toString();
        path=Environment.getExternalStorageDirectory()+
                File.separator+CARPETA_RAIZ+File.separator+nomArchivo+".xls";
       // String nomsolic=NomSolicitante.getText().toString();

        try {
            Workbook wb = Workbook.getWorkbook(new File(path));
            WritableWorkbook copy=Workbook.createWorkbook(new File(path),wb);
            WritableSheet copySheet=copy.getSheet(0);
            Label label1=new Label(11,6,date.getHours()+":"+date.getMinutes());
            Label label2=new Label(1,6,datee);
            //Label label3=new Label(1,4,"Todo Bien");
            copySheet.addCell(label1);
            copySheet.addCell(label2);
           // copySheet.addCell(label3);
            copy.write();
            copy.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createExcel() {
        String nomArchivo=NomArchivo.getText().toString();
        try {

            WritableWorkbook workbook = Workbook.createWorkbook(new File("/sdcard/"+nomArchivo+".xls"));
            workbook.createSheet("hola quetal",0);
            workbook.write();
            workbook.close();
        }
        catch (Exception e) {
         e.printStackTrace();
        }
    }

  /*  private void openWhatsApp() {
        String smsNumber = "8801714884544";
        boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        if (isWhatsappInstalled) {
            try { Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.setAction(Intent.ACTION_SEND); sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, FormViews.getTexBoxFieldValue(enquiryEditText));
                sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net");

            phone number without "+" prefix sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch(Exception e) { Toast.makeText(getActivity(), "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
        } } else { Uri uri = Uri.parse("market://details?id=com.whatsapp");
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        Toast.makeText(getActivity(), "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
        getActivity().startActivity(goToMarket);
        } } private boolean whatsappInstalledOrNot(String uri) { PackageManager pm = getActivity().getPackageManager();
        boolean app_installed = false;
        try { pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES); app_installed = true;
        } catch (PackageManager.NameNotFoundException e) { app_installed = false;
        } return app_installed;
            }
*/

    public void Whatsapp(View view) {
        path=Environment.getExternalStorageDirectory()+
                File.separator+CARPETA_RAIZ+File.separator+"Cesarr"+File.separator+"Construccion A"+File.separator+"Planta Baja"+File.separator+"Baja.jpg";
        String [] fotos = new String[10];

        fotos[0]=Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+"Cesarr"+File.separator+"Construccion A"+File.separator+"Planta Baja"+File.separator+"Baja.jpg";
        fotos[1]=Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+"Cesarr"+File.separator+"Construccion A"+File.separator+"Planta Baja"+File.separator+"Bj.jpg";




        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setAction(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/jpeg");

            ArrayList<Uri> uris = new ArrayList<Uri>();

            uris.add(Uri.parse(fotos[0]));
            uris.add(Uri.parse(fotos[1]));
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);



            //intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+"Cesarr"+File.separator+"Construccion A"+File.separator+"Planta Baja"+File.separator+"Baja.jpg"));
            intent.putExtra("jid", "59168453650" + "@s.whatsapp.net"); //numero telefonico sin prefijo "+"!
            intent.setPackage("com.whatsapp");
            startActivity(intent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "Whatsapp no esta instalado.", Toast.LENGTH_LONG).show();
        }



      // Intent i = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(path + "+59168453650.whatsapp.net"));
       // i.setPackage("com.whatsapp");
      //  startActivity(i);


     /*   try {
            //PackageManager packageManager = Context. getPackageManager();
            Intent i = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone="+ "59168453650" +"&image=" + Environment.getExternalStorageDirectory()+ File.separator+CARPETA_RAIZ+File.separator+"Cesarr"+File.separator+"Construccion A"+File.separator+"Planta Baja"+File.separator+"Baja.jpg";
            i.setPackage("com.whatsapp");
            i.setData(Uri.parse(url));
            startActivity(i);
            //if (i.resolveActivity(packageManager) != null) {
           //     Context.startActivity(i);
           // }
        } catch (Exception e){ e.printStackTrace();
        }

*/








 /*       String nomArchivo=NomArchivo.getText().toString();
        path=Environment.getExternalStorageDirectory()+
                File.separator+CARPETA_RAIZ+File.separator+"Cesarr"+File.separator+"Construccion A"+File.separator+"Planta Baja"+File.separator+"Baja.jpg";
for(int a=0;a<=fotos.length;a++){
    Uri uri;
    uri= Uri.parse(fotos[a]+ "+59168453650.whatsapp.net");

    Intent sendIntent = new Intent();
    sendIntent.setAction(Intent.ACTION_SEND);
    sendIntent.setPackage("com.whatsapp");
    sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
    //sendIntent.setType("application/vnd.ms-excel");
    sendIntent.setType("image/jpeg");
    startActivity(sendIntent);

}
*/



    }
}
