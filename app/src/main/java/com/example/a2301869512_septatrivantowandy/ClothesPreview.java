package com.example.a2301869512_septatrivantowandy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ClothesPreview extends AppCompatActivity {

    // untuk dapat diakses ke main activity
    public static final String EXTRA_TYPE = "com.example.a2301869512_septatrivantowandy.EXTRA_TYPE";
    public static final String EXTRA_COLOR = "com.example.a2301869512_septatrivantowandy.EXTRA_COLOR";
    public static final String EXTRA_SIZE = "com.example.a2301869512_septatrivantowandy.EXTRA_SIZE";

    private ImageView image; // deklarasi image
    private String strSpinner = null; // string pilihan user untuk type
    private String strSpinner2 = null; // string pilihan user untuk color
    private String strSpinner3 = null; // string pilihan user untuk size
    private Button butSaveCustom; // deklarasi tombol save customization

    public void backMainActivity(){ // yang terjadi ketika menekan tombol save customization

        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.putExtra(EXTRA_TYPE, strSpinner);
        resultIntent.putExtra(EXTRA_COLOR, strSpinner2);
        resultIntent.putExtra(EXTRA_SIZE, strSpinner3);

        startActivity(resultIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_preview);

        // mengambil data dari main activity
        Intent intent = getIntent();
        strSpinner = intent.getStringExtra(MainActivity.EXTRA_TYPE);
        strSpinner2 = intent.getStringExtra(MainActivity.EXTRA_COLOR);
        strSpinner3 = intent.getStringExtra(MainActivity.EXTRA_SIZE);

        // menampilkan data yang dipilih dari main activity
        TextView textViewType = findViewById(R.id.textViewInputType);
        TextView textViewColor = findViewById(R.id.textViewInputColor);
        TextView textViewSize = findViewById(R.id.textViewInputSize);

        textViewType.setText(strSpinner);
        textViewColor.setText(strSpinner2);
        textViewSize.setText(strSpinner3);

        // menampilkan dan memvalidasikan image
        image = findViewById(R.id.image);
        if(strSpinner.equals("Shirt")){
            if(strSpinner2.equals("Red")){
                image.setImageResource(R.drawable.red_shirt);
            }
            else if(strSpinner2.equals("Green")){
                image.setImageResource(R.drawable.green_shirt);
            }
            else if(strSpinner2.equals("Blue")){
                image.setImageResource(R.drawable.blue_shirt);
            }
        }
        else if(strSpinner.equals("Pants")){
            if(strSpinner2.equals("Red")){
                image.setImageResource(R.drawable.red_pants);
            }
            else if(strSpinner2.equals("Green")){
                image.setImageResource(R.drawable.green_pants);
            }
            else if(strSpinner2.equals("Blue")){
                image.setImageResource(R.drawable.blue_pants);
            }
        }
        else if(strSpinner.equals("Hat")){
            if(strSpinner2.equals("Red")){
                image.setImageResource(R.drawable.red_hat);
            }
            else if(strSpinner2.equals("Green")){
                image.setImageResource(R.drawable.green_hat);
            }
            else if(strSpinner2.equals("Blue")){
                image.setImageResource(R.drawable.blue_hat);
            }
        }

        //ketika menekan tombol Save Customization
        butSaveCustom = (Button) findViewById(R.id.buttonSaveCustom);
        butSaveCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMainActivity();
            }
        });

    }
}
