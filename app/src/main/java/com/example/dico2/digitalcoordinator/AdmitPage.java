package com.example.dico2.digitalcoordinator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class AdmitPage extends AppCompatActivity {


    CharSequence diags_string[];
    ArrayList<Diagnos> diags;
    ArrayList<Patient> patients;
    FloatingActionButton addDiagnosis;
    boolean add = true;
    Drawable plus = Drawable.createFromPath("@android:drawable/ic_input_add");
    Drawable minus = Drawable.createFromPath("@android:drawable/ic_delete");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admit_page);

        diags = Data.getInstance().getDiagnosis();
        patients = Data.getInstance().getPatients();

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

        Button fetch = findViewById(R.id.btn_fetch);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ssnInput = findViewById(R.id.txt_ssn);
                EditText nameInput = findViewById(R.id.txt_name);
                TextView diagtext = findViewById(R.id.text_diag);
                SeekBar brdn = findViewById(R.id.bar_burden);
                int ssn = Integer.parseInt(ssnInput.getText().toString());
                Patient newPat = null;
                for(Patient pat : patients)
                {
                    if(pat.getSsn() == ssn)
                    {
                        newPat = pat;
                        break;
                    }
                }

                if(newPat == null)
                {
                    newPat = new Patient(ssn, "", 2, null);
                    patients.add(newPat);
                }

                nameInput.setText(newPat.getName());
                brdn.setProgress(newPat.getburden() - 1);

                if(newPat.getDiagnosis() != null){
                    diagtext.setText(newPat.getDiagnosis().getDiagnos());
                    add = false;
                    addDiagnosis.setImageResource(R.drawable.ic_delete);
                } else {
                    diagtext.setText("");
                    add = true;
                    addDiagnosis.setImageResource(R.drawable.ic_input_add);
                }

            }
        });

        Button search = findViewById(R.id.btn_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText ssnInput = findViewById(R.id.txt_ssn);
                EditText nameInput = findViewById(R.id.txt_name);
                TextView diagtext = findViewById(R.id.text_diag);
                SeekBar brdn = findViewById(R.id.bar_burden);
                int ssn = Integer.parseInt(ssnInput.getText().toString());

                Diagnos newDiag = null;
                for(Diagnos d : diags)
                {
                    if(diagtext.getText() == d.getDiagnos()){
                        newDiag = d;
                    }
                }

                Patient newPat = null;
                for(Patient pat : patients)
                {
                    if(pat.getSsn() == ssn)
                    {
                        newPat = pat;
                        break;
                    }
                }

                if(newPat == null)
                {
                    newPat = new Patient(ssn, nameInput.getText().toString(), brdn.getProgress() - 1, newDiag);
                    patients.add(newPat);
                }

                Intent intent = new Intent(AdmitPage.this, ScreenSlidePagerActivity.class);
                intent.putExtra(ScreenSlidePageFragment.PATIENT_OBJECT,Integer.parseInt(ssnInput.getText().toString()));
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                finish();
            }
        }
    }

    public void ShowDiagnoses()
    {
        diags_string = new CharSequence[diags.size()];
        for(int i = 0; i < diags_string.length; i++)
        {
            diags_string[i] = diags.get(i).getDiagnos();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Diagnosis");
        builder.setItems(diags_string, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    TextView text = findViewById(R.id.text_diag);
                    text.setText(diags_string[which]);
                    addDiagnosis.setImageResource(R.drawable.ic_delete);
            }
        });
        builder.show();
    }
}
