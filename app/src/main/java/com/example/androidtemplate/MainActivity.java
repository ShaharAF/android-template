package com.example.androidtemplate;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rotateBtn = (Button) findViewById(R.id.rotate_btn);
        TextView orientationTv = (TextView) findViewById(R.id.orientation_txt);
        TextView rotationTv = (TextView) findViewById(R.id.rotation_txt);

        final int rotation = getWindowManager().getDefaultDisplay().getRotation();
        rotationTv.setText(Integer.toString(rotation));

        int orientation = getResources().getConfiguration().orientation;
        orientationTv.setText(Integer.toString(orientation));

        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "changing rotation", Toast.LENGTH_LONG).show();
                if(rotation == 0) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }else{
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
            }
        });
    }
}
