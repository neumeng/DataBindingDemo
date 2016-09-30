package com.neumeng.databindingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.neumeng.databindingdemo.basic.BasicActivity;
import com.neumeng.databindingdemo.dynamic.DynamicActivity;
import com.neumeng.databindingdemo.eventhandling.EventHandlingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showBasic(View view) {
        startActivity(new Intent(this,BasicActivity.class));
    }

    public void showDynamic(View view) {
        startActivity(new Intent(this,DynamicActivity.class));
    }
    public void showEventHandler(View view) {
        startActivity(new Intent(this,EventHandlingActivity.class));
    }
}
