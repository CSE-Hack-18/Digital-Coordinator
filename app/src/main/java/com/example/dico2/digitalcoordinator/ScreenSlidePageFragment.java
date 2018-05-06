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

public class ScreenSlidePageFragment extends Fragment {
    public final static String ARG_OBJECT = "object";
    public final static String PATIENT_OBJECT = "patientssn";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.fragment_screen_slide_page, container, false);
        Bundle args = getArguments();
        ImageView imageView = rootView.findViewById(R.id.imageView2);
        ImageView imageLoad = rootView.findViewById(R.id.imageloadview);
        TextView textView = rootView.findViewById(R.id.textView);
        TextView capText = rootView.findViewById(R.id.captext);
        final int page = args.getInt(ARG_OBJECT);

        Data data = Data.getInstance();
        final Patient patient = data.getPatient(args.getInt(PATIENT_OBJECT));
        ArrayList<Unit> units = data.getHospital().suggestedUnits(patient);
        final Unit unit = units.get(page - 1);

        String cap = "Capacity: " + unit.getPatients().size() + " / " + unit.getCapacity();
        capText.setText(cap);

        imageView.setImageResource(unit.getImage());
        String head = unit.getUnit();
        textView.setText(head);

        if(unit.comparableWorkLoad() < 2){
            imageLoad.setImageResource(R.drawable.load1);
        } else if(unit.comparableWorkLoad() <= 3){
            imageLoad.setImageResource(R.drawable.load2);
        } else {
            imageLoad.setImageResource(R.drawable.load3);
        }

        Button cancel = rootView.findViewById(R.id.cancelbutton);
        Button admit = rootView.findViewById(R.id.admitbutton);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                getActivity().setResult(getActivity().RESULT_CANCELED, returnIntent);
                getActivity().finish();
            }
        });

        admit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unit.getPatients().add(patient);
                Toast.makeText(getContext(),patient.getName() + " added to " + unit.getUnit(), Toast.LENGTH_LONG).show();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",1);
                getActivity().setResult(getActivity().RESULT_OK,returnIntent);
                getActivity().finish();
            }
        });





        return rootView;
    }
}
