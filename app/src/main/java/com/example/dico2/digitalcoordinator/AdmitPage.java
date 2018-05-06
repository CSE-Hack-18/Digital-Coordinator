package com.example.dico2.digitalcoordinator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class AdmitPage extends AppCompatActivity {


    CharSequence diags[] = new CharSequence[] {"Cancer", "Flesh Wound", "Flu", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack"
            , "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack", "Heart Attack"};

    FloatingActionButton addDiagnosis;
    boolean add = true;
    Drawable plus = Drawable.createFromPath("@android:drawable/ic_input_add");
    Drawable minus = Drawable.createFromPath("@android:drawable/ic_delete");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admit_page);

        addDiagnosis = (FloatingActionButton)findViewById(R.id.add_diag);
        addDiagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(add)
                {
                    ShowDiagnoses();
                    add = false;
                } else {
                    TextView text_diag = findViewById(R.id.text_diag);
                    text_diag.setText("");
                    add = true;
                    addDiagnosis.setImageResource(R.drawable.ic_input_add);
                }
            }
        });

        SeekBar seekBar = findViewById(R.id.bar_burden);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView brden = findViewById(R.id.txt_burden);
                brden.setText("" + (progress + 1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Write code to perform some action when touch is started.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Write code to perform some action when touch is stopped.
            }
        });



        Button search = findViewById(R.id.btn_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ssnInput = findViewById(R.id.txt_ssn);
                EditText nameInput = findViewById(R.id.txt_name);

                Intent intent = new Intent(AdmitPage.this, ScreenSlidePagerActivity.class);
                intent.putExtra(ScreenSlidePageFragment.PATIENT_OBJECT,Integer.parseInt(ssnInput.getText().toString()));
                startActivity(intent);
            }
        });

    }

    public void ShowDiagnoses()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Diagnosis");
        builder.setItems(diags, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    TextView text = findViewById(R.id.text_diag);
                    text.setText(diags[which]);
                    addDiagnosis.setImageResource(R.drawable.ic_delete);
            }
        });
        builder.show();
    }
}
