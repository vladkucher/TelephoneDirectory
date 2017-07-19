package ua.vld.util;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.vld.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonRepositoryUtil {
    public static void writeToFile(Gson gson, List<User> userList, String fileName){
        createIfNotExists(fileName);
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(userList,new TypeToken<List<User>>(){}.getType(),writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getFromFile(Gson gson, String fileName){
        createIfNotExists(fileName);
        try (Reader reader = new FileReader(fileName)) {
            return gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private static void createIfNotExists(String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            System.out.println("tyt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
