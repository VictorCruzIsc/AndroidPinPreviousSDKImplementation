package com.example.victorcruz.mypinimplementation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by victorcruz on 3/15/17.
 */

public class PinActivity extends AppCompatActivity implements View.OnClickListener{
    private boolean mKeyPadLockedFlag;
    private String mUserEntered;

    private Button iButton0;
    private Button iButton1;
    private Button iButton2;
    private Button iButton3;
    private Button iButton4;
    private Button iButton5;
    private Button iButton6;
    private Button iButton7;
    private Button iButton8;
    private Button iButton9;
    private Button iButtonDelete;
    private Button iButtonLogIn;
    private LinearLayout iLinearLayout;
    private TextView iNoPin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin_entry);

        iLinearLayout = (LinearLayout) findViewById(R.id.bullets);
        iNoPin = (TextView) findViewById(R.id.noPinEntered);
        setUpCustomKeyBoardPanel();

        mKeyPadLockedFlag = false;
        mUserEntered = "";
    }

    @Override
    public void onClick(View view) {
        if(mKeyPadLockedFlag){
            return;
        }

        switch (view.getId()){
            case R.id.logInPinButtton:
                Toast.makeText(this, mUserEntered, Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonDeleteBack:
                int userEnteredLength = mUserEntered.length();
                if(userEnteredLength > 0) {

                    removePasswordPoint();

                    mUserEntered = mUserEntered.substring(0, mUserEntered.length() - 1);

                    if (userEnteredLength == 1) {
                        iLinearLayout.addView(iNoPin);
                    }
                }
                break;
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
                Button pressedButton = (Button)view;
                if(mUserEntered.length() == 0){
                    iLinearLayout.removeView(iNoPin);
                }
                mUserEntered = mUserEntered + pressedButton.getText();
                addPasswordPoint();
                break;
        }
    }

    public void setUpCustomKeyBoardPanel(){
        iButton0 = (Button)findViewById(R.id.button0);
        iButton1 = (Button)findViewById(R.id.button1);
        iButton2 = (Button)findViewById(R.id.button2);
        iButton3 = (Button)findViewById(R.id.button3);
        iButton4 = (Button)findViewById(R.id.button4);
        iButton5 = (Button)findViewById(R.id.button5);
        iButton6 = (Button)findViewById(R.id.button6);
        iButton7 = (Button)findViewById(R.id.button7);
        iButton8 = (Button)findViewById(R.id.button8);
        iButton9 = (Button)findViewById(R.id.button9);
        iButtonDelete = (Button) findViewById(R.id.buttonDeleteBack);
        iButtonLogIn = (Button) findViewById(R.id.logInPinButtton);

        iButton0.setOnClickListener(this);
        iButton1.setOnClickListener(this);
        iButton2.setOnClickListener(this);
        iButton3.setOnClickListener(this);
        iButton4.setOnClickListener(this);
        iButton5.setOnClickListener(this);
        iButton6.setOnClickListener(this);
        iButton7.setOnClickListener(this);
        iButton8.setOnClickListener(this);
        iButton9.setOnClickListener(this);
        iButtonDelete.setOnClickListener(this);
        iButtonLogIn.setOnClickListener(this);
    }

    private ImageView createPasswordPoint(){
        ImageView point = new ImageView(this);
        point.setImageResource(R.mipmap.ic_launcher_round);
        point.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return point;
    }

    private void addPasswordPoint(){
        iLinearLayout.addView(createPasswordPoint());
    }

    private void removePasswordPoint(){
        int totalPasswordPoints = mUserEntered.length();
        int totalNewPasswordPoints = totalPasswordPoints - 1;

        iLinearLayout.removeAllViews();

        for(int i=0; i<totalNewPasswordPoints; i++){
            addPasswordPoint();
        }
    }
}
