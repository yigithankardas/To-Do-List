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
    
    public TodoPanel() {
        super();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(500, 360));

        descriptionPanel = new JPanel();
        descriptionPanel.setBackground(GUI.gray);
        descriptionPanel.setLayout(null);
        descriptionPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        descriptionPanel.setBounds(1, 80, 485, 282);

        deadlinePanel = new JPanel();
        deadlinePanel.setBackground(GUI.gray);
        deadlinePanel.setLayout(null);
        deadlinePanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        deadlinePanel.setBounds(1, 1, 378, 80);

        clockPanel = new JPanel();
        clockPanel.setBackground(GUI.gray);
        clockPanel.setLayout(null);
        clockPanel.setBorder(BorderFactory.createLineBorder(Color.yellow));
        clockPanel.setBounds(380, 0, 105, 80);

        descriptionField = new JTextField();
        descriptionField.setBackground(Color.black);
        descriptionField.setForeground(Color.white);
        descriptionField.setCaretColor(Color.gray);
        descriptionField.setFont(new Font("SansSerif", Font.PLAIN, 25));
        descriptionField.setBounds(1, 1, 482, 280);
        descriptionField.setBorder(BorderFactory.createEmptyBorder());
        descriptionPanel.add(descriptionField);

        deadlineLabel = new JLabel();
        deadlineLabel = new JLabel();
        deadlineLabel.setText("08/03/2021");
        deadlineLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
        deadlineLabel.setForeground(Color.white);
        deadlineLabel.setBounds(30, 1, 200, 70);
        deadlinePanel.add(deadlineLabel);

        clockLabel = new JLabel();
        clockLabel = new JLabel();
        clockLabel.setText("12:00");
        clockLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        clockLabel.setForeground(Color.white);
        clockLabel.setBounds(15, 1, 80, 70);
        clockPanel.add(clockLabel);

        this.add(descriptionPanel);
        this.add(clockPanel);
        this.add(deadlinePanel);
    }
}