package com.example.dico2.digitalcoordinator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
        TextView textView = rootView.findViewById(R.id.textView);
        int page = args.getInt(ARG_OBJECT);

        Data data = Data.getInstance();
        Patient patient = data.getPatient(args.getInt(PATIENT_OBJECT));
        ArrayList<Unit> units = data.getHospital().suggestedUnits(patient);
        Unit unit = units.get(page - 1);


        imageView.setImageResource(unit.getImage());
        String head = "Unit: " + unit.getUnit() + " Cap: " + unit.getCapacity() + " work: " + unit.comparableWorkLoad();
        textView.setText(head);





        return rootView;
    }
}
