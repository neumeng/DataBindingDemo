package com.neumeng.databindingdemo.basic;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neumeng.databindingdemo.R;
import com.neumeng.databindingdemo.model.User;
import com.neumeng.databindingdemo.databinding.ActivityBasicBinding;

public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBasicBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_basic);
        User user = new User("firstName", "lastName","address", "phone");
        binding.setUser(user);
    }
}
