package utils;

import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MyJsonParser {
    public static String getSourceFromTestData(String fileName) {
        JSONParser parser = new JSONParser();
        String source = null;
        try {
            JSONObject obj = (JSONObject) parser.parse(new FileReader(fileName));
            source = (String)obj.get("dataSource");

        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        }
        return source;
    }
}
