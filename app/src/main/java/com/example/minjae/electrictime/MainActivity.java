package com.example.minjae.electrictime;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText distance;
    private Button button;
    private Button electricTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        distance = (EditText) findViewById(R.id.distance);
        button = (Button) findViewById(R.id.act1);
        electricTime = (Button) findViewById(R.id.electrictime);

        button.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v) {
                openActivity();
            }
        });

        electricTime.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(distance.getText())) {
                    return;
                }
                if (!buttonCheck(button)) {
                    return;
                }
                calculateTime();
                distance.setText("");
                button.setText("Choose a vehicle");
            }
        });
    }

    public void openActivity() {
        Intent startNewActivity = new Intent(this, Main2Activity.class);
        startActivityForResult(startNewActivity, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            button.setText(data.getStringExtra("activity"));
        }
    }

    public void calculateTime() {
        Intent electricTimeActivity = new Intent(this, Main3Activity.class);
        electricTimeActivity.putExtra("distance", distance.getText().toString());
        electricTimeActivity.putExtra("activity", button.getText().toString());
        startActivity(electricTimeActivity);
    }

    public boolean buttonCheck(Button button) {
        if (button.getText().equals("Walking") || button.getText().equals("Boosted Mini S Board") ||
                button.getText().equals("Evolve Skateboard") || button.getText().equals("Segway i2 SE") || button.getText().equals("Hovertrax Hoverboard")) {
            return true;
        }
        return false;
    }
}