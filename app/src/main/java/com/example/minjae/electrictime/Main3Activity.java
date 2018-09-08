package com.example.minjae.electrictime;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Main3Activity extends Activity {

    private double distance;
    private String activity;
    private TextView output;
    private Button  menu;
    private Button compare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        output = (TextView) findViewById(R.id.output);
        menu = (Button) findViewById(R.id.menu);
        compare = (Button) findViewById(R.id.compare);
        Intent intent = getIntent();
        distance = Double.parseDouble(intent.getStringExtra("distance"));
        activity = intent.getStringExtra("activity");
        output.setText(String.format("%s: %.2f minutes.", activity, displayElectricTime(distance, activity)));

        menu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        compare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                gotoCompare();
            }
        });
    }

    public double displayElectricTime(double dist, String act) {
        if (act.equals("Walking")) {
            return dist/3.1;
        } else if (act.equals("Boosted Mini S Board")){
            return dist/18.0;
        } else if (act.equals("Evolve SkateBoard")) {
            return dist/26.0;
        } else if (act.equals("Segway i2 SE")) {
            return dist/12.5;
        } else {
            return dist/8.0;
        }
    }

    public void gotoCompare() {
        Intent compareMenu = new Intent(this, Main4Activity.class);
        compareMenu.putExtra("activity", activity);
        compareMenu.putExtra("distance", Double.toString(distance));
        startActivity(compareMenu);
    }
}
