package com.nafsoft.aspireacademy;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ApplicationProvider;

import com.google.firebase.storage.FirebaseStorage;
import com.nafsoft.aspireacademy.pdfsection.pdfAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;


@RunWith(MockitoJUnitRunner.class)
public class pdfAdapterTest {

    @Mock
    private RecyclerView mockRecyclerView;

    @Mock
    private FirebaseStorage mockFirebaseStorage;

    private Context context;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        // Mock FirebaseStorage instance
        Mockito.when(FirebaseStorage.getInstance()).thenReturn(mockFirebaseStorage);
    }

    @Test
    public void testGetItemCount() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Test File 1");
        items.add("Test File 2");
        items.add("Test File 3");

        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://example.com/file1.pdf");
        urls.add("https://example.com/file2.pdf");
        urls.add("https://example.com/file3.pdf");

        pdfAdapter adapter = new pdfAdapter(mockRecyclerView, null, items, urls);

        assertEquals(3, adapter.getItemCount());
    }

}
