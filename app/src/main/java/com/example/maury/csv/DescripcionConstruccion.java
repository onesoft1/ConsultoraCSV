package com.example.maury.csv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.multispinner.MultiSelectSpinner;

import java.util.List;

public class DescripcionConstruccion extends AppCompatActivity implements MultiSelectSpinner.OnMultipleItemsSelectedListener {

    TextView archi;
    String archi1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_construccion);
        archi= (TextView) findViewById(R.id.archivo);
        archi1=getIntent().getExtras().getString("archivo");
        archi.setText(archi1);

        //
        String[] array = {"None", "Losa Radier", "Hormigón Armado", "Hormigón Ciclópeo", "Piedra", "Ladrillo", "Piedra y Barro"};
        MultiSelectSpinner multiSelectSpinner = (MultiSelectSpinner) findViewById(R.id.spinner);
        multiSelectSpinner.setItems(array);
        multiSelectSpinner.hasNoneOption(true);
        multiSelectSpinner.setSelection(new int[]{0});
        multiSelectSpinner.setListener(this);


        String[] array1 = {"None", "Hormigón Armado", "mixta de H°A° y muros portantes", "muros portantes con encadenado", "muros portantes sin encadenado", "metálica", "madera"};
        MultiSelectSpinner multiSelectSpinner1 = (MultiSelectSpinner) findViewById(R.id.spinnerestructura);
        multiSelectSpinner1.setItems(array1);
        multiSelectSpinner1.hasNoneOption(true);
        multiSelectSpinner1.setSelection(new int[]{0});
      // multiSelectSpinner1.setListener(this);
        multiSelectSpinner1.setListener(new MultiSelectSpinner.OnMultipleItemsSelectedListener() {
            @Override
            public void selectedIndices(List<Integer> indices) {

            }

            @Override
            public void selectedStrings(List<String> strings) {
                Toast.makeText(getApplicationContext(), "Componentes Seleccionados son todo :" + strings, Toast.LENGTH_LONG).show();

            }
        });




    }




    public void siguiente(View view) {
        String nomArchivo=archi.getText().toString();
        Intent i=new Intent(this,CapturaImagen.class);
        i.putExtra("archivo",nomArchivo);
        startActivity(i);
    }

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {



        Toast.makeText(this.getApplicationContext(),"Componentes Seleccionados" + strings,Toast.LENGTH_LONG).show();

    }
}
