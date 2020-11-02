package Homework03_03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int i;
        List<String> ls = new ArrayList<>();
        for (i = 1; i <= 10; i++) {
            Scanner scanner = new Scanner(System.in);
            String mess = scanner.nextLine();
            ls.add(i + ": " + mess);

        }
        String listString = " ";
        for (String s : ls) {
            listString += s + "\n";
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter("D:\\GB\\Homework_03\\src\\Homework03_03\\archive.txt");
            writer.write(listString);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
