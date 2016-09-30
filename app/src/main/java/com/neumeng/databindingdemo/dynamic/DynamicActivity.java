package com.neumeng.databindingdemo.dynamic;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neumeng.databindingdemo.R;
import com.neumeng.databindingdemo.model.User;
import com.neumeng.databindingdemo.databinding.ActivityDynamicBinding;
import com.neumeng.databindingdemo.databinding.UserItemBinding;

import java.util.ArrayList;
import java.util.List;

public class DynamicActivity extends AppCompatActivity {
    ActivityDynamicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_dynamic);
        initRv();
    }

    private void initRv() {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        MyAdapter adapter = new MyAdapter(this,genUsers());
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    private List<User> genUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            User user = new User("firstName:" + i, "lastName:" + i, "address:" + i, "phone:" + i);
            users.add(user);
        }
        return users;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private Context context;
        private List<User> users;
        public class MyViewHolder extends RecyclerView.ViewHolder {
            private UserItemBinding binding;

            public MyViewHolder(View itemView) {
                super(itemView);
            }

            public UserItemBinding getBinding() {
                return binding;
            }

            public void setBinding(UserItemBinding binding) {
                this.binding = binding;
            }
        }
        public MyAdapter(Context context, List<User> users) {
            this.context = context;
            this.users = users;
        }

        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            UserItemBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.getContext()),
                    R.layout.user_item,
                    parent,
                    false);
            MyAdapter.MyViewHolder holder = new MyAdapter.MyViewHolder(binding.getRoot());
            holder.setBinding(binding);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            User user = users.get(position);
            holder.binding.setVariable(com.neumeng.databindingdemo.BR.user,user);
            holder.binding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}
