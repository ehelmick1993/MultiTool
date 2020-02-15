package elh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.vccs.email.elh22232.lab.myapp.R;

public class Converter extends Fragment {

    String spinA;
    String spinB;
    TextView answer;
    EditText input;
    Button calculate;
    Spinner spinnerA;
    Spinner spinnerB;
    ConvertValue convert = new ConvertValue();
    double inputVal = 0;
    double outputVal = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Converter");


        ArrayAdapter<CharSequence> adapterA;
        ArrayAdapter<CharSequence> adapterB;

        calculate = (Button)getView().findViewById(R.id.convertbutton);
        answer = (TextView)getView().findViewById(R.id.convertanswer);
        input = (EditText) getView().findViewById(R.id.editvalue);

        spinnerA = (Spinner)getView().findViewById(R.id.spinnerA);
        spinnerB = (Spinner)getView().findViewById(R.id.spinnerB);

        adapterA = ArrayAdapter.createFromResource(getContext(),
                R.array.conversions, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterB = ArrayAdapter.createFromResource(getContext(),
                R.array.conversions, android.R.layout.simple_spinner_item);
        adapterB.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerA.setAdapter(adapterA);
        spinnerB.setAdapter(adapterB);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputVal = Double.parseDouble(input.getText().toString());
                spinA = spinnerA.getSelectedItem().toString();
                spinB = spinnerB.getSelectedItem().toString();


                if(spinnerA.getSelectedItem().toString().equals("Inches")){

                }

                if(spinA.equals("Centimeters")){
                    switch(spinB){
                        case "Inches":
                            answer.setText(input.getText() + " " + spinA + " equals " +
                            String.format("%.2f", convert.cmToInch(inputVal))
                            + " " + spinB);
                            break;
                        case "Centimeters":
                            answer.setText(input.getText().toString());
                            break;
                        case "Feet":
                            answer.setText(String.format("%.2f", convert.cmToFeet(inputVal)));
                            break;
                        case "Meters":
                            answer.setText(String.format("%.2f", convert.cmToMeter(inputVal)));
                            break;
                        case "Miles":
                            answer.setText(String.format("%.2f", convert.cmToMile(inputVal)));
                            break;
                        case "Kilometers":
                            answer.setText(String.format("%.2f", convert.cmToKilometer(inputVal)));
                            break;
                        case "Yards":

                            break;

                    }
                }

                if(spinnerA.getSelectedItem().toString().equals("Feet")){

                }

                if(spinnerA.getSelectedItem().toString().equals("Meters")){

                }

                if(spinnerA.getSelectedItem().toString().equals("Miles")){

                }

                if(spinnerA.getSelectedItem().toString().equals("Kilometers")){

                }

                if(spinnerA.getSelectedItem().toString().equals("Yards")){

                }

            }
        });

    //answer.setText(spinnerA.getSelectedItem().toString());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.converter, container, false);
    }

    private double halfMyNum(double num){

        return num / 2;
    }

    private double doubleMyNum(double num){

        return num * 2;
    }

}
