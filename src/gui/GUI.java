package gui;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public GUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setBounds(500, 25, 500, 400);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(40, 40, 40));
        frame.add(panel);

        JLabel label = new JLabel();
        label.setText("Hello new project!");
        label.setFont(new Font("Seriff", Font.ITALIC, 30));
        label.setForeground(Color.white);
        panel.add(label);

        frame.setVisible(true);
        frame.setSize(500, 398);
        frame.setSize(500, 440);
    }
}
