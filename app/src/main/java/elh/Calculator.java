package elh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.vccs.email.elh22232.lab.myapp.R;

//known bugs:
//if operand button is pressed before appropriate entry, app crashes

//need to add decimal button functions
//need to add carrot button functions
//need to add percent button functions

public class Calculator extends Fragment {
    
    //create ui elements
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button decimal;
    private Button negate;
    private Button equal;
    private Button multiply;
    private Button add;
    private Button sub;
    private Button divide;
    private Button percent;
    private Button power;
    private Button clear;
    private TextView display;
    private TextView displayInfo;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char POWER = '^';
    private final char EQUALS = 0;
    private double val1 = Double.NaN;
    private double val2 = Double.NaN;
    private char ACTION;
    private String temp;


    //on create method to start gui thread    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //create activity title
        getActivity().setTitle("Calculator");
        
        //call method to build ui
        setupUIView();

        //on click method for clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                refreshApp();
            }
        });

        //on click method for 0 button
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "0");
            }
        });

        //on click method for 1 button
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "1");
            }
        });

        //on click method for 2 button
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "2");
            }
        });

        //on click method for 3 button
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "3");
            }
        });

        //on click method for 4 button
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "4");
            }
        });

        //on click method for 5 button
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "5");
            }
        });

        //on click method for 6 button
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "6");
            }
        });

        //on click method for 7 button
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "7");
            }
        });

        //on click method for 8 button
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "8");
            }
        });

        //on click method for 9 button
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInfo.setText(displayInfo.getText().toString() + "9");
            }
        });
        
        //on click method for + button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(displayInfo.getText().toString().equals(""))) {
                    compute();
                    ACTION = ADDITION;
                    display.setText(String.valueOf(val1) + " + ");
                    displayInfo.setText(null);
                }
            }
        });

        //on click method for - button
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(displayInfo.getText().toString().equals(""))) {
                    compute();
                    ACTION = SUBTRACTION;
                    display.setText(String.valueOf(val1) + " - ");
                    displayInfo.setText(null);
                }
            }
        });

        //on click method for * button
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(displayInfo.getText().toString().equals(""))) {
                    compute();
                    ACTION = MULTIPLICATION;
                    display.setText(String.valueOf(val1) + " * ");
                    displayInfo.setText(null);
                }
            }
        });

        //on click method for / button
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(displayInfo.getText().toString().equals(""))) {
                    compute();
                    ACTION = DIVISION;
                    display.setText(String.valueOf(val1) + " / ");
                    displayInfo.setText("");
                }
            }
        });

        //on click method for ^ button
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(displayInfo.getText().toString().equals(""))) {
                    compute();
                    ACTION = POWER;
                    display.setText(String.valueOf(val1) + " ^ ");
                    displayInfo.setText("");
                }
            }
        });

        //on click method for = button
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(displayInfo.getText().toString().equals("")))
                    compute();
                    ACTION = EQUALS;
                    display.setText(String.valueOf(val1));
                    if(display.getText().toString().equals("NaN")){
                        display.setText("");
                    }
                    refreshApp();
                }
        });

    }

    //app drawer control
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
        @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.calculator, container, false);
    }

    //links java gui elements to xml elements
    private void setupUIView(){

        zero = (Button)getView().findViewById(R.id.button_0);
        one = (Button)getView().findViewById(R.id.button_1);
        two = (Button)getView().findViewById(R.id.button_2);
        three = (Button)getView().findViewById(R.id.button_3);
        four = (Button)getView().findViewById(R.id.button_4);
        five = (Button)getView().findViewById(R.id.button_5);
        six = (Button)getView().findViewById(R.id.button_6);
        seven = (Button)getView().findViewById(R.id.button_7);
        eight = (Button)getView().findViewById(R.id.button_8);
        nine = (Button)getView().findViewById(R.id.button_9);
        decimal = (Button)getView().findViewById(R.id.button_dec);
        negate = (Button)getView().findViewById(R.id.button_neg);
        equal = (Button)getView().findViewById(R.id.button_eql);
        multiply = (Button)getView().findViewById(R.id.button_mult);
        add = (Button)getView().findViewById(R.id.button_add);
        sub = (Button)getView().findViewById(R.id.button_sub);
        divide = (Button)getView().findViewById(R.id.button_div);
        percent = (Button)getView().findViewById(R.id.button_prcnt);
        power = (Button)getView().findViewById(R.id.button_pwr);
        clear = (Button)getView().findViewById(R.id.button_clr);
        display = (TextView)getView().findViewById(R.id.display);
        displayInfo = (TextView)getView().findViewById(R.id.displayinfo);
    }

    //refreshes int values for val1 and val2
    private void refreshApp(){
        val1 = Double.NaN;
        val2 = Double.NaN;
        displayInfo.setText("");
    }

    //method to performe computations based on user click
    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(displayInfo.getText().toString());

            //switch steps through proper cases to calculate value based on user selection
            switch (ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    val1 = val1 / val2;
                    break;
                case POWER:
                    val1 = Math.pow(val1, val2);
                case EQUALS:
                    break;
            }
        }
        
        //set display value to val1 if no operation is performed
        else{
            val1 = Double.parseDouble(displayInfo.getText().toString());
        }
    }
}
