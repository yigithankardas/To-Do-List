package gui;

import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame frame;

    private JPanel mainPanel;

    private JScrollPane scroll;

    public static Color gray;

    public GUI() {
        frame = new JFrame();
        mainPanel = new JPanel();
        scroll = new JScrollPane(mainPanel);

        gray = new Color(40, 40, 40);
        frame.setResizable(false);
        arrange();
        frame.setSize(515, 390);
        frame.setSize(515, 400);
    }

    private void arrange() {
        frame.setDefaultCloseOperation(3);
        frame.setBounds(515, 100, 500, 400);

        mainPanel.setLayout(new WrapLayout());
        mainPanel.setBackground(gray);

        scroll.setBounds(0, 0, 500, 400);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(50);

        TodoPanel panel1 = new TodoPanel();
        TodoPanel panel2 = new TodoPanel();
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        
        frame.add(scroll);
        frame.setVisible(true);
    }
}