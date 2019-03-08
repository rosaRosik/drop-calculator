package com.rosik.rosa.dropcalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
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
    private TextView poprawka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        oblicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int  m = Integer.parseInt(odleglosc.getText().toString());
                int  n = Integer.parseInt(opad.getText().toString());

                if(mils.isChecked()){

                    float w = n / (1 * (float)m/100);

                    wynik.setText("JAK TO LICZYĆ?\n"+
                                  "______\n"+
                            "1 MILS na 100 m = 10cm\n" +
                            "1/10 MILS na 100m = 1cm\n" +
                            "WIĘC:\n\n" +
                            "1/10 MILS na "+m+"m -> 1cm * "+(float)m/100 +" = "+ (float)m/100+"cm\n"+
                            n + "/"+(float)m/100 +" = "+w+"\n"
                            );

                    // w to twoja poprawka
                    poprawka.setText(w + " KLIK");

                }else if(moa4.isChecked()){
                  moa(m,n,0.75,4);

                }else if(moa6.isChecked()){

                    moa(m,n,0.5,6);

                }else if (moa8.isChecked()){

                    moa(m,n,0.375,8);

                }else{

                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Zapomniałeś o czymś")
                            .setMessage("Podaj nazwe celownika mordeczko ;3")


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
        poprawka = (TextView)findViewById(R.id.poprawka);

    }

    public void moa(int metry, int opad,double nastawa,int moa){

        double w = opad / (nastawa * (float)metry/100);
        double roundOff = Math.round(w * 100.0) / 100.0;
        double m4 = Math.round((nastawa * (float)metry/100) * 100.0) / 100.0;
        wynik.setText("JAK TO LICZYĆ?\n"+
                "\n1 MOA na 100m    = 3cm\n" +
                "1/"+moa+" MOA na 100m  = "+ nastawa*10 +" mm\n" +
                "\nWIĘC:\n"+
                "1/"+moa+" MOA na "+metry + "m" +" -> "+nastawa*10+"mm *"+(float)metry/100 +" = "+ m4+ "cm\n"+
                opad +"/"+m4 +" = "+ roundOff+"\n"
                );

        //w to twoja poprawka
        poprawka.setText(w + " KLIK");

    }


}
