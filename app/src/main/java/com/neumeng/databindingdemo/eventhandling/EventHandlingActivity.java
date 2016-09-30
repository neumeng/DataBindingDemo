package com.neumeng.databindingdemo.eventhandling;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.neumeng.databindingdemo.R;
import com.neumeng.databindingdemo.databinding.ActivityEventHandlingBinding;

public class EventHandlingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_event_handling);
        ActivityEventHandlingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_event_handling);
        Handlers handlers = new Handlers();
        binding.setHandlers(handlers);
        Presenters presenters = new Presenters();
        binding.setPresenters(presenters);
    }
}
