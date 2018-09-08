package com.example.minjae.electrictime;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main4Activity extends Activity {

    private String activity;
    private double distance;
    private TextView act1;
    private TextView act2;
    private TextView act3;
    private TextView act4;
    private Button back;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Intent intent = getIntent();
        activity = intent.getStringExtra("activity");
        distance = Double.parseDouble(intent.getStringExtra("distance"));
        menu = (Button) findViewById(R.id.menu);
        back = (Button) findViewById(R.id.back);
        act1 = (TextView) findViewById(R.id.act1);
        act2 = (TextView) findViewById(R.id.act2);
        act3 = (TextView) findViewById(R.id.act3);
        act4 = (TextView) findViewById(R.id.act4);
        setAct();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoMenu();
            }
        });
    }

    public void setAct() {
        if (activity.equals("Walking")){
            act1.setText(String.format("%s: %.2f minutes.", "Boosted Mini S Board", calculateBoosted(distance)));
            act2.setText(String.format("%s: %.2f minutes.", "Evolve Skateboard", calculateEvolve(distance)));
            act3.setText(String.format("%s: %.2f minutes.", "Segway i2 SE", calculateSegway(distance)));
            act4.setText(String.format("%s: %.2f minutes.", "Hovertrax Hoverboard", calculateHoverboard(distance)));
        } else if (activity.equals("Boosted Mini S Board")) {
            act1.setText(String.format("%s: %.2f minutes.", "Walking", calculateWalking(distance)));
            act2.setText(String.format("%s: %.2f minutes.", "Evolve Skateboard", calculateEvolve(distance)));
            act3.setText(String.format("%s: %.2f minutes.", "Segway i2 SE", calculateSegway(distance)));
            act4.setText(String.format("%s: %.2f minutes.", "Hovertrax Hoverboard", calculateHoverboard(distance)));
        } else if (activity.equals("Evolve Skateboard")) {
            act1.setText(String.format("%s: %.2f minutes.", "Walking", calculateWalking(distance)));
            act2.setText(String.format("%s: %.2f minutes.", "Boosted Mini S Board", calculateBoosted(distance)));
            act3.setText(String.format("%s: %.2f minutes.", "Segway i2 SE", calculateSegway(distance)));
            act4.setText(String.format("%s: %.2f minutes.", "Hovertrax Hoverboard", calculateHoverboard(distance)));
        } else if (activity.equals("Segway i2 SE")) {
            act1.setText(String.format("%s: %.2f minutes.", "Walking", calculateWalking(distance)));
            act2.setText(String.format("%s: %.2f minutes.", "Boosted Mini S Board", calculateBoosted(distance)));
            act3.setText(String.format("%s: %.2f minutes.", "Evolve Skateboard", calculateEvolve(distance)));
            act4.setText(String.format("%s: %.2f minutes.", "Hovertrax Hoverboard", calculateHoverboard(distance)));
        } else {
            act1.setText(String.format("%s: %.2f minutes.", "Walking", calculateWalking(distance)));
            act2.setText(String.format("%s: %.2f minutes.", "Boosted Mini S Board", calculateBoosted(distance)));
            act3.setText(String.format("%s: %.2f minutes.", "Evolve Skateboard", calculateEvolve(distance)));
            act4.setText(String.format("%s: %.2f minutes.", "Segway i2 SE", calculateSegway(distance)));
        }
    }

    public double calculateWalking(double distance) {
        return distance/3.1;
    }

    public double calculateBoosted(double distance) {
        return distance/18.0;
    }

    public double calculateEvolve(double distance) {
        return distance/26.0;
    }

    public double calculateSegway(double distance) {
        return distance/12.5;
    }

    public double calculateHoverboard(double distance) {
        return distance/8.0;
    }

    public void gotoMenu() {
        Intent mainMenu = new Intent(this, MainActivity.class);
        mainMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainMenu);
        finish();
    }

}
