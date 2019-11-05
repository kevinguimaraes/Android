package com.example.correcaoprevisaotempo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.correcaoprevisaotempo.R;
import com.example.correcaoprevisaotempo.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = new MainControl(this);
    }
}
