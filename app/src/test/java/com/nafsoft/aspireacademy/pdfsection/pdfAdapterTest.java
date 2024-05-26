package com.nafsoft.aspireacademy.pdfsection;

import static org.junit.Assert.*;
import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class pdfAdapterTest {
    private pdfAdapter adapter;
    private ArrayList<String> items;
    private ArrayList<String> urls;

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        RecyclerView recyclerView = new RecyclerView(context);
        items = new ArrayList<>();
        urls = new ArrayList<>();
        adapter = new pdfAdapter(recyclerView, context, items, urls);
    }

    @Test
    public void getItemCount_EmptyList_ReturnsZero() {
        assertEquals(0, adapter.getItemCount());
    }

    @Test
    public void getItemCount_NonEmptyList_ReturnsCorrectCount() {
        items.add("Item 1");
        urls.add("url1");
        items.add("Item 2");
        urls.add("url2");
        assertEquals(2, adapter.getItemCount());
    }

    @Test
    public void getItemCount_AddItem_ReturnsUpdatedCount() {
        items.add("Item 1");
        urls.add("url1");
        assertEquals(1, adapter.getItemCount());
        items.add("Item 2");
        urls.add("url2");
        assertEquals(2, adapter.getItemCount());
    }
}