package com.nafsoft.aspireacademy.Authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nafsoft.aspireacademy.R;

public class UserUpdate extends AppCompatActivity {

    TextInputEditText userName;
    ProgressBar progressBar;
    Drawable drawable;
    TextView recover;
    FirebaseAuth auth;


    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        userName = findViewById(R.id.forgotEmailUpdate);
        recover=findViewById(R.id.toRecoveUpdate);
        progressBar =findViewById(R.id.progressUpdate);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userName.setText(user.getDisplayName());

        drawable = getResources().getDrawable(R.drawable.baseline_error_24,null);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        recover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=userName.getText().toString().trim();
                if(name.isEmpty())
                {
                    userName.setError("Enter Your userName",drawable);
                    userName.requestFocus();
                }
                else
                {

                    progressBar.setVisibility(View.VISIBLE);
                    updateUserName(name);

                }
            }
        });





    }

    private void updateUserName(String userName) {

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        reference = FirebaseDatabase.getInstance("https://innocent-bird-default-rtdb.asia-southeast1" +
                ".firebasedatabase.app").getReference();
        if(user != null)
        {
            reference.child("Users").child(user.getUid()).child("userName").setValue(userName);
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(userName)
                    .build();
            auth.getCurrentUser().updateProfile(profileUpdates);

            Toast.makeText(this, "UserName Updated Successfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "OPPS! something went wrong", Toast.LENGTH_SHORT).show();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressBar.setVisibility(View.INVISIBLE);
            }
        },1200);




    }
}