package com.example.mehdi.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button Scaner = (Button) findViewById(R.id.scanButton);
        final ImageView UpArrow = (ImageView) findViewById(R.id.fleche);
        UpArrow.setVisibility(View.INVISIBLE);

        Scaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpArrow.setVisibility(View.VISIBLE);
            }
        });
    }
}