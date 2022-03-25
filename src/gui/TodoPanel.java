package gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class TodoPanel extends JPanel {

    private JPanel descriptionPanel;
    private JPanel deadlinePanel;
    private JPanel clockPanel;

    private JLabel deadlineLabel;
    private JLabel clockLabel;
 
    private JTextField descriptionField;
    
    public TodoPanel(String description, String deadline, String clock) {
        super();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(600, 370));

        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(GUI.gray);
        descriptionPanel.setLayout(null);
        //descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        descriptionPanel.setBounds(0, 80, 590, 295);

        deadlinePanel = new JPanel();
        deadlinePanel.setBackground(GUI.gray);
        deadlinePanel.setLayout(null);
        deadlinePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        deadlinePanel.setBounds(0, 0, 433, 80);

        clockPanel = new JPanel();
        clockPanel.setBackground(GUI.darkGray);
        clockPanel.setLayout(null);
        //clockPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        clockPanel.setBounds(433, 0, 167, 80);

        descriptionField = new JTextField();
        descriptionField.setBackground(Color.black);
        descriptionField.setForeground(Color.white);
        descriptionField.setCaretColor(Color.gray);
        descriptionField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        descriptionField.setBounds(0, 0, 590, 295);
        descriptionField.setBorder(BorderFactory.createEmptyBorder());
        descriptionField.setText(description);
        descriptionPanel.add(descriptionField);

        deadlineLabel = new JLabel();
        deadlineLabel = new JLabel();
        deadlineLabel.setText(deadline);
        deadlineLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
        deadlineLabel.setForeground(Color.white);
        deadlineLabel.setBounds(30, 0, 200, 70);
        deadlinePanel.add(deadlineLabel);

        clockLabel = new JLabel();
        clockLabel = new JLabel();
        clockLabel.setText(clock);
        clockLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        clockLabel.setForeground(Color.white);
        clockLabel.setBounds(15, 0, 80, 70);
        clockPanel.add(clockLabel);

        this.add(descriptionPanel);
        this.add(clockPanel);
        this.add(deadlinePanel);
    }
}