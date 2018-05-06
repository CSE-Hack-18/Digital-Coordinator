package com.example.dico2.digitalcoordinator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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
        int page = args.getInt(ARG_OBJECT);

        Data data = Data.getInstance();
        data.getPatient()

        if (page == 1){
            imageView.setImageResource(R.drawable.zombie);
        } else if(page == 2){
            imageView.setImageResource(R.drawable.flower);
        } else if(page == 3){
            imageView.setImageResource(R.drawable.heartbeat);
        } else if(page == 4){
            imageView.setImageResource(R.drawable.skeleton);
        } else if(page == 5){
            imageView.setImageResource(R.drawable.skeleton);
        } else if(page == 6){
            imageView.setImageResource(R.drawable.skeleton);
        }



        return rootView;
    }
}
