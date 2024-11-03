package com.example.alertdialogboxexample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // single Button Dialog Box
//        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle("Terms & Condition");
//        alertDialog.setIcon(R.drawable.baseline_info_24);
//        alertDialog.setMessage("Have you read all the T & C");
//
//        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes, I've Read", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Yes, You can proceed now...", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        alertDialog.show();

        // Double Button dialog Box
        AlertDialog.Builder delDialog = new AlertDialog.Builder(this);
        delDialog.setTitle("Delete");
        delDialog.setIcon(R.drawable.baseline_delete_24);
        delDialog.setMessage("Are you sure want to Delete?");

        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Deleted...", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Canceled!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        delDialog.show();


    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder exitDialog= new AlertDialog.Builder(this);
        exitDialog.setTitle("Exit?");
        exitDialog.setMessage("Are you sure want to exit?");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.super.onBackPressed();
            }
        });
        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Operation Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.show();

    }
}