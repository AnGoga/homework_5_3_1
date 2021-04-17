import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Gson gson = new Gson();
    private static File file = new File("users.txt");

    public static void main(String[] args){
        saveData();
        loadData();
    }

    private static void saveData() {
        User user = new User();
        user.setFirstname("Name");
        user.setLastname("Familia");
        user.setSchool(1511);

        String userJson = gson.toJson(user);

        try{
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.append(userJson);
            fileWriter.flush();
        }catch (Exception e){}
    }

    private static void loadData() {
        User user = getUsers();
        System.out.println(user.toString());
    }

    private static User getUsers() {
        try {
            Scanner scanner = new Scanner(file);
            String json = "";
            while (scanner.hasNextLine()){
                json += scanner.nextLine();
            }
            return gson.fromJson(json, User.class);
        }catch (Exception e){
            e.printStackTrace();
        };
        return null;
    }
}

