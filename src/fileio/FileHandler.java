package fileio;

import java.io.*;
import java.util.Scanner;

public class FileHandler {

    private File file;
    private String text;
    private StringBuilder builder;
    private Scanner scan;

    public FileHandler(File file) {
        this.file = file;
        builder = new StringBuilder("");
        readFile();
    }

    private void readFile() {
        try {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception thrown in \'FileHandler\' class.");
            System.exit(0);
        }

        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
            builder.append("\n");
        }
        text = builder.toString();
        if (text.length() - 1 > 0)
            while (text.charAt(text.length() - 1) == '\n')
                text = text.substring(0, text.length() - 1);
        builder = null;
    }
}