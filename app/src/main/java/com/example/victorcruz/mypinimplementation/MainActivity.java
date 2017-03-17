package com.example.victorcruz.mypinimplementation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public final String TAG = MainActivity.class.getSimpleName();

    Button iLogInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iLogInBtn = (Button) findViewById(R.id.button);

        iLogInBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Log.d(TAG, "Click on LogIn button");
                Intent intent = new Intent(this, PinActivity.class);
                if(intent != null) {
                    startActivity(intent);
                }
                break;
        }
    }
}
