package com.example.sumung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class matjib extends AppCompatActivity {

    private Button 한식,중식,양식,분식,고기;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matjib);

        한식 = findViewById(R.id.한식);
        한식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(matjib.this , hansik.class);
                startActivity(intent);
            }
        });

        중식 = findViewById(R.id.중식);
        중식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(matjib.this , joongsik.class);
                startActivity(intent);
            }
        });

        양식 = findViewById(R.id.양식);
        양식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(matjib.this , yangsik.class);
                startActivity(intent);
            }
        });

        분식 = findViewById(R.id.분식);
        분식.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(matjib.this , boonsik.class);
                startActivity(intent);
            }
        });

        고기 = findViewById(R.id.고기);
        고기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(matjib.this , gogi.class);
                startActivity(intent);
            }
        });


    }
}