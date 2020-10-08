package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class DataReader {
    public static String readValueFromJson(String key){
        String returnValue = "";

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            //read test data.json in the resources directory
            InputStream inputStream = new FileInputStream(new File("src/test/resources/testdata.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
}

