package com.nafsoft.aspireacademy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nafsoft.aspireacademy.examsection.views.ListFragment;

public class MainActivity extends AppCompatActivity {

    private Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newButton=findViewById(R.id.gotoFragment);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newButton.setVisibility(View.GONE);
                Fragment listFrag= new ListFragment();
                FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainContainer,listFrag).commit();
            }
        });



    }
}