package com.nafsoft.aspireacademy.examsection.views.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nafsoft.aspireacademy.examsection.views.Model.QuestionModel;
import com.nafsoft.aspireacademy.examsection.views.repository.QuestionRepository;


import java.util.HashMap;
import java.util.List;

public class QuestionViewModel implements QuestionRepository.OnQuestionLoad {

    private MutableLiveData<List<QuestionModel>> questionMutableLiveData;
    private QuestionRepository repository;
    private MutableLiveData<HashMap<String , Long>> resultMutableLiveData;

    public MutableLiveData<HashMap<String, Long>> getResultMutableLiveData() {
        return resultMutableLiveData;
    }

//    public void getResults(){
//        repository.getResults();
//    }

    public MutableLiveData<List<QuestionModel>> getQuestionMutableLiveData() {
        return questionMutableLiveData;
    }

    public QuestionViewModel(){
        questionMutableLiveData = new MutableLiveData<>();
        //resultMutableLiveData = new MutableLiveData<>();
        repository = new QuestionRepository(this);
    }
//    public void addResults(HashMap<String , Object> resultMap){
//        repository.addResults(resultMap);
//    }

    public void setExamId(String examId){
        repository.setExamId(examId);
    }

    public void getQuestions(){
        repository.getQuestions();
    }

    @Override
    public void onLoad(List<QuestionModel> questionModels) {
        questionMutableLiveData.setValue(questionModels);
    }

//    @Override
//    public boolean onSubmit() {
//        return true;
//    }


//    @Override
//    public void onResultLoad(HashMap<String, Long> resultMap) {
//        resultMutableLiveData.setValue(resultMap);
//    }

    @Override
    public void onError(Exception e) {
        Log.d("QuizError", "onError: " + e.getMessage());
    }
}