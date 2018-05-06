package com.example.dico2.digitalcoordinator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DischargeFragment extends Fragment {
    public final static String ARG_OBJECT = "object";
    public final static String PATIENT_OBJECT = "patientssn";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.fragment_screen_slide_page_discharge, container, false);
        Bundle args = getArguments();
        ImageView imageFace = rootView.findViewById(R.id.faceImage);
        TextView textView = rootView.findViewById(R.id.textView);
        TextView unitText = rootView.findViewById(R.id.unittext);
        final int page = args.getInt(ARG_OBJECT);

        final Data data = Data.getInstance();

        imageFace.setImageResource(R.drawable.deadface);
        String head = data.getAllPatientsAdmitted().get(page-1).getName();
        textView.setText(head);

        int tempssn = data.getAllPatientsAdmitted().get(page-1).getSsn();
        String unittexthead = data.getPatientUnit(tempssn);
        unitText.setText(unittexthead);


        Button cancel = rootView.findViewById(R.id.cancelbutton);
        Button discharge = rootView.findViewById(R.id.admitbutton);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        discharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ssndis = data.getAllPatientsAdmitted().get(page-1).getSsn();
                Toast.makeText(getContext(),data.getPatient(ssndis).getName() + " discharged.", Toast.LENGTH_LONG).show();
                data.dischargePatient(ssndis);
                getActivity().finish();
            }
        });





        return rootView;
    }
}
