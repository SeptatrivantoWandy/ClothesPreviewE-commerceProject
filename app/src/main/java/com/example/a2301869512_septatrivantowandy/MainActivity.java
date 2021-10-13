package com.example.a2301869512_septatrivantowandy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Untuk dapat diakses oleh ClothesPreview(Activity ke-2)
    public static final String EXTRA_TYPE = "com.example.a2301869512_septatrivantowandy.EXTRA_TYPE";
    public static final String EXTRA_COLOR = "com.example.a2301869512_septatrivantowandy.EXTRA_COLOR";
    public static final String EXTRA_SIZE = "com.example.a2301869512_septatrivantowandy.EXTRA_SIZE";


    private Button butView; // tombol View
    private Button butLoadCus; // tombol Load Customization
    private String strSpinner = null; //spinner untuk Type
    private String strSpinner2 = null; // spinner untuk color
    private String strSpinner3 = null; // spinner untuk size
    private String inputStrSpinner = null; // temp spinner type saat dipilih user
    private String inputStrSpinner2 = null; // temp spinner color saat dipilih user
    private String inputStrSpinner3 = null; // temp spinner size saat dipilih user
    private String resultStrSpinner; // temp spinner type saat save customization
    private String resultStrSpinner2; // temp spinner color saat save customization
    private String resultStrSpinner3; // temp spinner size saat save customization


    // saat akan memasuki class ClothesPreview
    public void clothesPreview(){
        Intent intent = new Intent(this, ClothesPreview.class);
        intent.putExtra(EXTRA_TYPE, strSpinner);
        intent.putExtra(EXTRA_COLOR, strSpinner2);
        intent.putExtra(EXTRA_SIZE, strSpinner3);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Deklarasi spinner untuk type
        Spinner spinner = (Spinner) findViewById(R.id.spinnerType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //  Deklarasi spinner untuk color
        Spinner spinner2 = (Spinner) findViewById(R.id.spinnerColor);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        //  Deklarasi spinner untuk size
        Spinner spinner3 = (Spinner) findViewById(R.id.spinnerSize);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.size, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        butView = (Button) findViewById(R.id.buttonView); // deklarasi tombol View

        // menginput type saat spinner dipilih
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputStrSpinner = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // menginput color saat spinner dipilih
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputStrSpinner2 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // menginput size saat spinner dipilih
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                inputStrSpinner3 = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // deklarasi tombol view jika diklik
        butView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strSpinner = inputStrSpinner;
                strSpinner2 = inputStrSpinner2;
                strSpinner3 = inputStrSpinner3;

                //validasi pemilihan spinner sampai tidak ada pilihan default
                if(strSpinner.equals("Pick a type")){
                    String toast = "Pick a type";
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_SHORT).show();
                }
                if(strSpinner2.equals("Pick a color")){
                    String toast = "Pick a color";
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_SHORT).show();
                }
                if(strSpinner3.equals("Pick a size")){
                    String toast = "Pick a size";
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_SHORT).show();
                }
                if(!(strSpinner.equals("Pick a type") || strSpinner2.equals("Pick a color") || strSpinner3.equals("Pick a size"))){

                    clothesPreview();
                }

            }
        });


        // deklarasi mengambil data dari class ClothesPreview jika menekan tombol save customization
        Intent intent = getIntent();
        resultStrSpinner = intent.getStringExtra(ClothesPreview.EXTRA_TYPE);
        resultStrSpinner2 = intent.getStringExtra(ClothesPreview.EXTRA_COLOR);
        resultStrSpinner3 = intent.getStringExtra(ClothesPreview.EXTRA_SIZE);


        butLoadCus = (Button) findViewById(R.id.buttonLoadCus); // deklarasi tombol Load Customization

        // deklarasi tombol Load Customization ketika di klik
        butLoadCus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validasi jika belum ada data yang di save
                if(resultStrSpinner == null || resultStrSpinner2 == null || resultStrSpinner3 == null){
                    String toast = "You have not saved any preview";
                    Toast.makeText(getApplicationContext(),toast,Toast.LENGTH_SHORT).show();
                }
                // validasi jika ada data yang di save
                else{
                    strSpinner = resultStrSpinner;
                    strSpinner2 = resultStrSpinner2;
                    strSpinner3 = resultStrSpinner3;
                    clothesPreview();
                }
                /*NOTE: KETIKA MEMASUKI ACTIVITY CLOTHES PREVIEW LALU TIDAK DI SAVE DAN INGIN KEMBALI KE MAIN ACTIVITY,
                LOAD CUSTOMIZATION AKAN BERFUNGSI JIKA MENEKAN TOMBOL KEMBALI DARI SMARTPHONE (YANG ADA DI BAGIAN BAWAH SEBELAH KANAN)
                JIKA MENEKAN TOMBOL KEMBALI DARI APLIKASI (YANG ADA DI BAGIAN ATAS SEBELAH KIRI) MAKA DATA AKAN DIHAPUS
                DAN LOAD CUSTOMIZATION TIDAK BERFUNGSI.

                 */

            }
        });



    }




}
