package com.example.liaoli.officedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) throws IOException, InterruptedException {
       manager  m =  new manager();

        m.setUp();
        m.serializeAndDeserialize();
    }
}
