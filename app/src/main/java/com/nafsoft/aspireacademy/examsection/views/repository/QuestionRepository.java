package com.nafsoft.aspireacademy.examsection.views.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;
import com.nafsoft.aspireacademy.examsection.views.Model.QuestionModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class QuestionRepository {
    private FirebaseFirestore firebaseFirestore;
    private String examId;

    private OnQuestionLoad onQuestionLoad;

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public  QuestionRepository(OnQuestionLoad onQuestionLoad){
        firebaseFirestore = FirebaseFirestore.getInstance();
        this.onQuestionLoad=onQuestionLoad;
    }

    public void getQuestions(){
        firebaseFirestore.collection("Exam").document(examId).collection("Question").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull  Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            onQuestionLoad.onLoad(task.getResult().toObjects(QuestionModel.class));
                        }else{
                            onQuestionLoad.onError(task.getException());
                        }
                    }
                });
    }

    public interface OnResultLoad{
        void onResultLoad(HashMap<String , Long> resultMap);
        void onError(Exception e);
    }

    public interface OnQuestionLoad{
        void onLoad(List<QuestionModel> questionModels);
        void onError(Exception e);
    }
    public interface OnResultAdded{
        boolean onSubmit();
        void onError(Exception e);
    }
}
