package com.nafsoft.aspireacademy.examsection.views.Model;

import com.google.firebase.firestore.DocumentId;

public class ExamListModel {

    @DocumentId
    private String examId;
    private String Title,Image;
    private Long Questions;

    public ExamListModel(){}

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Long getQuestions() {
        return Questions;
    }

    public void setQuestions(Long Question) {
        this.Questions = Question;
    }
    public ExamListModel(String examId, String Title, String Image, Long Questions) {
        this.examId = examId;
        this.Title = Title;
        this.Image = Image;
        this.Questions = Questions;
    }
}