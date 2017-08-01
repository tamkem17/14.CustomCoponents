package com.example.tam.a14customcoponents;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private customView mCustomView;
    private ImageButton mImgbtnChooseColor;
    private EditText mEdtWidth, mEdtHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomView = (customView) findViewById(R.id.view);
        mEdtWidth = (EditText)findViewById(R.id.edt_sizeWidth);
        mEdtHeight = (EditText)findViewById(R.id.edt_sizeHeight);
        Button btnDraw = (Button)findViewById(R.id.btn_draw);
        btnDraw.setOnClickListener(new DrawRectagle());
    }

    private class DrawRectagle implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String widthString, heightString;
            widthString = mEdtWidth.getText().toString();
            heightString = mEdtHeight.getText().toString();
            if(widthString == null || heightString == null) {
                Toast.makeText(getApplicationContext(), "You are not allowed to leave blank", Toast.LENGTH_LONG).show();
            }
            else {
                try {
                    Float width = Float.parseFloat(mEdtWidth.getText().toString());
                    Float height = Float.parseFloat(mEdtHeight.getText().toString());
                    mCustomView.setSizeRectagle(width, height);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "You are only allowed to enter a number", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void ChooseColorClick(View view){
        if(view != mImgbtnChooseColor) {
            ImageButton imgView = (ImageButton)view;
            String colorImageButton = view.getTag().toString();
            int newColor = Color.parseColor(colorImageButton);
            mCustomView.setColor(newColor);
        }
    }
}
