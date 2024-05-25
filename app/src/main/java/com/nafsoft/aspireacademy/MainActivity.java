package com.nafsoft.aspireacademy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nafsoft.aspireacademy.Authentication.Login;
import com.nafsoft.aspireacademy.Authentication.UserUpdate;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    public TextView userEmail, userName ,  userHomeName ;
    public CardView   admission , hsc ,ssc ;

    FirebaseDatabase database;
    DatabaseReference reference;

    FirebaseAuth auth;

    // for drawer layout
    private DrawerLayout drawerLayout;
    Toolbar toolbar;

    FirebaseUser firebaseUser;

    private Button newButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        admission = findViewById(R.id.admissionCard);
        hsc = findViewById(R.id.hscCard);
        ssc = findViewById(R.id.sscCard);
        userHomeName = findViewById(R.id.userHomeName);

        auth = FirebaseAuth.getInstance();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        userHomeName.setText("Welcome " + firebaseUser.getDisplayName());

        //For Drawer start

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //finding the The buttons
        NavigationView navigationViewUser = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        userEmail = headerView.findViewById(R.id.drawerUserMail);
        userName = headerView.findViewById(R.id.drawerNameUser);

        userName.setText(firebaseUser.getDisplayName());
        userEmail.setText(firebaseUser.getEmail());



        //end of drawer

        /*
        * Now I will handle all the card click event which is
        * */

        admission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , CourseDetails.class);
                startActivity(i);
            }
        });
        hsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Upcoming HSC section", Toast.LENGTH_SHORT).show();
            }
        });
        ssc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Upcoming SSC section", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //for drawer


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int getUid=item.getItemId();

        if(getUid == R.id.nav_home)
        {

            Intent i = new Intent(MainActivity.this,MainActivity.class);
            startActivity(i);
        }
        else if(getUid == R.id.nav_user){

            Intent i = new Intent(MainActivity.this, UserUpdate.class);
            startActivity(i);


        }else if(getUid == R.id.nav_creator){

            Intent i = new Intent(MainActivity.this, AboutUs.class);
            startActivity(i);


        }
        else if(getUid == R.id.nav_logOutDrawer)
        {

            auth.signOut();
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
            finish();
            Toast.makeText(MainActivity.this, "Log Out successfully", Toast.LENGTH_SHORT).show();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    //end drawer


    @Override
    public void onBackPressed() {

        //for drawer
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Are You sure you want to QUIT App?");
            builder.setCancelable(false);

            builder.setNegativeButton("QUIT APP", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);
                }
            });

            builder.setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.create().show();
        }


    }
}