package com.nafsoft.aspireacademy.examsection.views.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nafsoft.aspireacademy.examsection.views.Model.QuestionModel;
import com.nafsoft.aspireacademy.examsection.views.repository.QuestionRepository;

import java.util.List;

public class QuestionViewModel extends ViewModel implements QuestionRepository.OnQuestionLoad {
    private MutableLiveData<List<QuestionModel>> questionMutableLiveData;
    private QuestionRepository repository;
    public MutableLiveData<List<QuestionModel>> getQuestionMutableLiveData() {
        return questionMutableLiveData;
    }
    public QuestionViewModel()
    {
        questionMutableLiveData=new MutableLiveData<>();
        repository= new QuestionRepository(this);
    }

    public void getQuestions(){
        repository.getQuestions();
    }

    public void setExamId(String examId){
        repository.setExamId(examId);
        repository.getQuestions();
    }
    @Override
    public void onLoad(List<QuestionModel> questionModels) {
        questionMutableLiveData.setValue(questionModels);
    }

    @Override
    public void onError(Exception e) {
        Log.d("ExamError","onError:"+e.getMessage());
    }
}
