package com.rosik.rosa.dropcalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private Button oblicz;

    private RadioGroup radio;
    private RadioButton mils;
    private RadioButton moa4;
    private RadioButton moa6;
    private RadioButton moa8;

    private EditText odleglosc;
    private EditText opad;
    private TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mils.isChecked()){

                    wynik.setText("milsy");

                }else if(moa4.isChecked()){

                    wynik.setText("moa 1/4");

                }else if(moa6.isChecked()){

                    wynik.setText("moa1/6");

                }else if (moa8.isChecked()){

                    wynik.setText("moa1/8");

                }else{

                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Zapomniałeś o czymś")
                            .setMessage("Podaj nazwe celownika mordeczko")


                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            }
        });



    }

    public void setupUIViews(){

        radio = (RadioGroup)findViewById(R.id.radio);
        oblicz = (Button)findViewById(R.id.count);
        mils = (RadioButton)findViewById(R.id.mils);
        moa4 = (RadioButton)findViewById(R.id.moa4);
        moa6 = (RadioButton)findViewById(R.id.moa6);
        moa8 = (RadioButton)findViewById(R.id.moa8);
        odleglosc = (EditText)findViewById(R.id.meters);
        opad = (EditText)findViewById(R.id.centy);
        wynik = (TextView)findViewById(R.id.wynik);
    }


}
