package com.nafsoft.aspireacademy.examsection.views.Adapter;


import com.nafsoft.aspireacademy.examsection.views.Model.ExamListModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExamListAdapterTest {

    private ExamListAdapter adapter;

    @Before
    public void setUp() {
        adapter = new ExamListAdapter(null);
    }

    @Test
    public void testGetItemCountWithNonEmptyList() {
        List<ExamListModel> examList = Arrays.asList(
                new ExamListModel("Exam 1", "https://example.com/image1.png", "Description 1", "ID1", 123456789L),
                new ExamListModel("Exam 2", "https://example.com/image2.png", "Description 2", "ID2", 123456790L)
        );
        adapter.setExamListModels(examList);
        assertEquals(2, adapter.getItemCount());
    }

    @Test
    public void testGetItemCountWithEmptyList() {
        List<ExamListModel> examList = new ArrayList<>();
        adapter.setExamListModels(examList);
        assertEquals(0, adapter.getItemCount());
    }

    @Test
    public void testGetItemCountWithNullList() {
        adapter.setExamListModels(null);
        assertEquals(0, adapter.getItemCount());
    }

    @Test
    public void testGetItemCountWithSingleItem() {
        List<ExamListModel> examList = Arrays.asList(
                new ExamListModel("Exam 1", "https://example.com/image1.png", "Description 1", "ID1", 123456789L)
        );
        adapter.setExamListModels(examList);
        assertEquals(1, adapter.getItemCount());
    }
}
