package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {

    private ArrayList<String> list;

    private JFrame frame;

    private JPanel mainPanel;
    private JPanel descriptionPanel;
    private JPanel deadlinePanel;
    private JPanel clockPanel;

    private JLabel deadlineLabel;
    private JLabel clockLabel;

    private JTextField descriptionField;

    private Color gray;

    public GUI() {
        list = new ArrayList<>();
        frame = new JFrame();

        mainPanel = new JPanel();
        descriptionPanel = new JPanel();
        deadlinePanel = new JPanel();
        clockPanel = new JPanel();

        deadlineLabel = new JLabel();
        clockLabel = new JLabel();

        descriptionField = new JTextField();

        gray = new Color(40, 40, 40);
        frame.setResizable(false);
        arrange();
        frame.setSize(500, 390);
        frame.setSize(500, 400);
    }

    private void arrange() {
        frame.setDefaultCloseOperation(3);
        frame.setBounds(500, 100, 500, 400);

        mainPanel.setBackground(gray);
        mainPanel.setLayout(null);
        descriptionPanel.setBackground(gray);
        descriptionPanel.setLayout(null);
        descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        descriptionPanel.setBounds(1, 80, 485, 282);
        deadlinePanel.setBackground(gray);
        deadlinePanel.setLayout(null);
        deadlinePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        deadlinePanel.setBounds(1, 1, 378, 80);
        clockPanel.setBackground(gray);
        clockPanel.setLayout(null);
        clockPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        clockPanel.setBounds(380, 0, 105, 80);

        descriptionField.setBackground(Color.black);
        descriptionField.setForeground(Color.white);
        descriptionField.setCaretColor(Color.gray);
        descriptionField.setFont(new Font("Seriff", Font.PLAIN, 25));
        descriptionField.setBounds(1, 1, 482, 280);
        descriptionField.setBorder(BorderFactory.createEmptyBorder());
        descriptionPanel.add(descriptionField);
        mainPanel.add(descriptionPanel);
        mainPanel.add(clockPanel);
        mainPanel.add(deadlinePanel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}