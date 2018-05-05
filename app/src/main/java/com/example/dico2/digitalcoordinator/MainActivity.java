package com.example.dico2.digitalcoordinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button swipeactivity = findViewById(R.id.admitswipe);
        swipeactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AdmitSwipe.class);
                startActivity(intent);
            }
        });

        Button startAcivity = findViewById(R.id.start_page);
        startAcivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StartPage.class);
                startActivity(intent);
            }
        });
    }
}
