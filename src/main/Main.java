package main;

import gui.GUI;
import java.io.*;

import fileio.FileHandler;
public class Main {
    public static void main(String[] args) {
        File file = new File(System.getenv("USERPROFILE") + "/todolist.txt");
        boolean exist = false;
        try {
			exist = file.createNewFile();
		} 
		catch (IOException e) {
			System.out.println("Exception in \'Main\' class.");
            System.exit(0);
		}

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write("description,09/03/2022,08:00\ndescription2,10/03/2022,09:15");
        writer.close();

        FileHandler handler = new FileHandler(file);
        new GUI(handler);

        if (exist)
            GUI.initial();
    }
}