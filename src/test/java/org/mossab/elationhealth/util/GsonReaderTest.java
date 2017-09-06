package org.mossab.elationhealth.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by mossab on 9/6/17.
 *
 * @author: mossab
 */
public class GsonReaderTest {
    private static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

    @Test
    public void testInitialReaderWorks() throws FileNotFoundException {
        GsonReader reader = new GsonReader(gson, "initial_lab_results.json");
        Assert.assertEquals(reader.readFile().size(), 240000);
    }

    @Test
    public void testUpdatedReaderWorks() throws FileNotFoundException {
        GsonReader reader = new GsonReader(gson, "new_lab_results.json");
        Assert.assertEquals(reader.readFile().size(), 20);
    }

    @Test(expected = NullPointerException.class)
    public void testFailedReaderException() throws FileNotFoundException {
        GsonReader reader = new GsonReader(gson, "some_nonsense_file.txt");
        Assert.assertEquals(reader.readFile().size(), 240000);
    }
}