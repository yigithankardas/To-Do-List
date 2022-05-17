package fileio;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    public static class Node {
        private String description;
        private String deadline;
        private String clock;

        public Node(String description, String deadline, String clock) {
            this.description = description;
            this.deadline = deadline;
            this.clock = clock;
        }

        public String description() {
            return this.description;
        }
        public String deadline() {
            return this.deadline;
        }
        public String clock() {
            return this.clock;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        public void setDeadline(String deadline) {
            this.deadline = deadline;
        }
        public void setClock(String clock) {
            this.clock = clock;
        }
    }

    private File file;
    private String text;
    private StringBuilder builder;
    private Scanner scan;
    private ArrayList<Node> list;
    private PrintWriter writer;

    public FileHandler(File file) {
        this.file = file;
        list = new ArrayList<>();
        builder = new StringBuilder("");
        writer = null;
        readFileFillArray();
    }

    public ArrayList<Node> getNodeList() {
        return this.list;
    }

    private void readFileFillArray() {
        try {
            scan = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception in \'FileHandler\' class.");
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

        scan = new Scanner(text);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            int descriptionIndex = line.indexOf(",");
            String description = line.substring(0, descriptionIndex);
            line = line.substring(descriptionIndex + 1);
            int deadlineIndex = line.indexOf(",");
            String deadline = line.substring(0, deadlineIndex);
            line = line.substring(deadlineIndex + 1);
            String clock = line;

            list.add(new Node(description, deadline, clock));
        }
        scan.close();
    }

    public void output() {
        try {
            writer = new PrintWriter(file);
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Node panel : list) {
            writer.write(panel.description + "," + panel.deadline + "," + panel.clock + "\n");
        }
        writer.close();
    }
}