package com.example.minjae.electrictime;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends Activity {

    Button walking;
    Button boosted;
    Button evolve;
    Button segway;
    Button hoverboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        walking = (Button) findViewById(R.id.walking);
        boosted = (Button) findViewById(R.id.boosted);
        evolve = (Button) findViewById(R.id.evolve);
        segway = (Button) findViewById(R.id.segway);
        hoverboard = (Button) findViewById(R.id.hoverboard);

        walking.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                finishActivity(walking);
            }
        });

        boosted.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                finishActivity(boosted);
            }
        });

        evolve.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                finishActivity(evolve);
            }
        });

        segway.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                finishActivity(segway);
            }
        });

        hoverboard.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                finishActivity(hoverboard);
            }
        });
    }

    private void finishActivity(Button button) {
        Intent fin = new Intent();
        fin.putExtra("activity", button.getText().toString());
        setResult(RESULT_OK, fin);
        finish();
    }

}
