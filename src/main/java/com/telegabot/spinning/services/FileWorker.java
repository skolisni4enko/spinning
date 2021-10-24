package com.telegabot.spinning.services;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class FileWorker {
    private final List<String> stringFromFile = new ArrayList<>();

    public String getStringFromFile(){
        try {
            FileReader fileReader = new FileReader("text.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String nextString = bufferedReader.readLine();
            while (nextString != null) {
                if (!nextString.equals("*")){
                    stringFromFile.add(nextString);
                }
                nextString = bufferedReader.readLine();
            }

            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int a = (int) (Math.random() * stringFromFile.size());
        return stringFromFile.get(a);
    }

    public void setStringToFile(String user){
        try(FileWriter writer = new FileWriter("users.txt", true))
        {
            // запись всей строки
            writer.write(user);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
