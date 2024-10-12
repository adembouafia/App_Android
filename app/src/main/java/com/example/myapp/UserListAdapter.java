package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserAdapter> {
    private Context context;
    private ArrayList first_name, last_name, email;

    public UserListAdapter(Context context, ArrayList first_name, ArrayList last_name, ArrayList email) {
        this.context = context;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }


    @NonNull
    @Override
    public UserAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.userentry, parent, false);
        return new UserAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter holder, int position) {
        String firstname = String.valueOf(first_name.get(position));
        String lastname = String.valueOf(last_name.get(position));
        String e_mail = String.valueOf(email.get(position));
        holder.first_name.setText(String.valueOf(first_name.get(position)));
        holder.last_name.setText(String.valueOf(last_name.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
    }

    @Override
    public int getItemCount() {
        return first_name.size();
    }

    public class UserAdapter extends RecyclerView.ViewHolder {
        TextView first_name, last_name, email;
        public UserAdapter(@NonNull View itemView) {
            super(itemView);
            first_name = itemView.findViewById(R.id.firstname);
            last_name = itemView.findViewById(R.id.lastname);
            email = itemView.findViewById(R.id.email);
        }
    }
}
