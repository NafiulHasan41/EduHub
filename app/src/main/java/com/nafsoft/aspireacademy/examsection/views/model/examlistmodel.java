package com.nafsoft.aspireacademy.examsection.views.model;

import com.google.firebase.firestore.DocumentId;

public class examlistmodel {
    @DocumentId
    private String examId;
    private String Title, image;
    private long Question;
    public examlistmodel(){}

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getQuestion() {
        return Question;
    }

    public void setQuestion(long question) {
        Question = question;
    }

    public examlistmodel(String examId, String title, String image, long question) {
        this.examId = examId;
        Title = title;
        this.image = image;
        Question = question;
    }
}
