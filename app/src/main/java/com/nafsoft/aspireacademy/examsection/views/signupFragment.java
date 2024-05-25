package com.nafsoft.aspireacademy.examsection.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.nafsoft.aspireacademy.R;
import com.nafsoft.aspireacademy.examsection.views.viewmodel.AuthViewModel;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class signupFragment extends Fragment {

    private AuthViewModel viewModel;
    private NavController navController;
    private EditText editEmail, editPass;
    private TextView signInText;
    private Button signUpBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        editEmail=view.findViewById(R.id.editEmailSignUp);
        editPass=view.findViewById(R.id.editPassSignUp);
        signInText=view.findViewById(R.id.signInText);
        signUpBtn=view.findViewById(R.id.signUpBtn);
        signInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_signupFragment_to_loginFragment);
            }
        });
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=editEmail.getText().toString();
                String pass= editPass.getText().toString();
                if(!email.isEmpty()&&!pass.isEmpty())
                {
                    viewModel.signUp(email,pass);
                    Toast.makeText(getContext(),"Registered Successfull", Toast.LENGTH_SHORT).show();
                    viewModel.getFirebaseUserMutableLiveData().observe(getViewLifecycleOwner(), new Observer<FirebaseUser>() {
                        @Override
                        public void onChanged(FirebaseUser firebaseUser) {
                            if(firebaseUser!=null)
                            {
                                navController.navigate(R.id.action_signupFragment_to_loginFragment);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(getContext(),"Please enter email and pass", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this , ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthViewModel.class);

    }
}