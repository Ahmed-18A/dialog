package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Dialog d;
    AlertDialog.Builder dialog2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog2 = new AlertDialog.Builder(this);
        dialog2.setTitle("Welcome");
        dialog2.setCancelable(false);
        dialog2.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        d=new Dialog(this);
        d.setContentView(R.layout.dialog_custom);
        EditText name = d.findViewById(R.id.name);
        EditText pass = d.findViewById(R.id.pass);
        Button log = d.findViewById(R.id.log);
        Button cancel = d.findViewById(R.id.cancel);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String password = pass.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in both fields", Toast.LENGTH_SHORT).show();
                } else {
                    if (username.equals("admin")&& password.equals("admin")) {
                        Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        d.dismiss();
                        dialog2.create().show();
                    }
                    else
                        Toast.makeText(MainActivity.this, "wrong info", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });

        d.setCancelable(true);
    }

    public void dialog(View view) {
        d.show();
    }
}