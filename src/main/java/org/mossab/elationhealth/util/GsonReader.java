package org.mossab.elationhealth.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.mossab.elationhealth.lab.LabResult;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

/**
 * Created by mossab on 9/6/17.
 *
 * @author: mossab
 */
public class GsonReader {
    private final Gson gson;
    private final String fileName;


    public GsonReader(Gson gson, String fileName) {
        this.gson = gson;
        this.fileName = fileName;
    }

    public List<LabResult> readFile() throws FileNotFoundException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(this.fileName);
        BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
        Type type = new TypeToken<List<LabResult>>() {
        }.getType();
        return this.gson.fromJson(br, type);
    }
}
