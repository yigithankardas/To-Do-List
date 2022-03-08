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
        FileHandler handler = new FileHandler(file);
        new GUI(handler);

        if (exist)
            GUI.initial();
    }
}