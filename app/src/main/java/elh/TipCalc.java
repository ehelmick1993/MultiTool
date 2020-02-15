package elh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import edu.vccs.email.elh22232.lab.myapp.R;

public class TipCalc extends Fragment {

    private EditText initialBill;
    private double INITIALBILL = 0;
    private TextView tipPercent;
    private double TIPPERCENT = 0;
    private SeekBar seekBar;
    private TextView tipTotal;
    private double TIPTOTAL = 0;
    private TextView finalBill;
    private double FINALBILL = 0;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Tip Calc");
        setupUIView();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress < 9){
                    tipPercent.setText(String.valueOf(progress) + "% Tip (Very Poor Service)");
                }
                else if(progress < 14){
                    tipPercent.setText(String.valueOf(progress) + "% Tip (Poor Service)");
                }
                else if (progress < 19){
                    tipPercent.setText(String.valueOf(progress) + "% Tip (Average Service)");
                }
                else if (progress < 24){
                    tipPercent.setText(String.valueOf(progress) + "% Tip (Above Average Service)");
                }
                else{
                    tipPercent.setText(String.valueOf(progress) + "% Tip (Excellent Service)");
                }


                TIPPERCENT = progress;
                calculate();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tipcalc, container, false);
    }

    private void setupUIView(){

        initialBill = (EditText) getView().findViewById(R.id.initialbill);
        initialBill.setText("0");
        tipPercent = (TextView) getView().findViewById(R.id.tippercent);
        seekBar = (SeekBar) getView().findViewById(R.id.seekbar);
        tipTotal = (TextView) getView().findViewById(R.id.tiptotal);
        tipTotal.setText("Tip Total: $");
        finalBill = (TextView) getView().findViewById(R.id.finalbill);
        finalBill.setText("Final Bill: $");
    }

    private void calculate(){

        INITIALBILL = Double.parseDouble(initialBill.getText().toString());
        TIPTOTAL = INITIALBILL * (TIPPERCENT / 100);
        FINALBILL = TIPTOTAL + INITIALBILL;

        tipTotal.setText("Tip Total: $" + String.format("%.2f", TIPTOTAL));
        finalBill.setText("Final Bill: $" + String.format("%.2f", FINALBILL));
    }
}
