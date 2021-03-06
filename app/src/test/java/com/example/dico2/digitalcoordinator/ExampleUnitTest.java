package com.example.dico2.digitalcoordinator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testSuggested() {
        Data data = Data.getInstance();
        Hospital hospital = new Hospital();
        hospital.setUnits(data.getUnits());
        System.out.println(hospital.getUnits().get(0).getUnit());

        /*

        for (int i = 0; i < (data.getPatients().size()) ;i++){
            System.out.println(i);
            System.out.println(data.getPatients().get(i).getName());
        }*/
       /* ArrayList<Unit> result = hospital.suggestedUnits(data.getPatients().get(0));

        System.out.println("\n" + data.getPatients().get(0).getName());
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).getUnit());
        }
*/
        hospital.getUnits().get(0).setPatients(data.getPatients());
        System.out.println(hospital.getUnits().get(0).getUnit());

        ArrayList<Unit> result = hospital.suggestedUnits(data.getPatients().get(0));
        System.out.println(data.getPatients().get(6).getName());
        System.out.println("\n" + data.getPatients().get(6).getName());
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).getUnit() + " , " + result.get(i).comparableWorkLoad());

        }
        assertEquals(4, 2 + 2);
    }
}