package bots.botsMessageHandler.utils;

import org.json.JSONArray;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class readAndWriteToFile {


    public static JSONArray readFile(){
        JSONArray arr = null;
        try {
            String text = new String(Files.readAllBytes(Paths.get("lsdUsers.json")), StandardCharsets.UTF_8);
            if (text.equals("")) {
                arr = new JSONArray();
            } else {
                arr = new JSONArray(text);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }
}
