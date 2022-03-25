package gui;

import javax.swing.*;

import fileio.FileHandler;
import fileio.FileHandler.Node;
import gui.highlights.AddPanelHighlighter;
import gui.listeners.OnCloseListener;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI {

	private ArrayList<TodoPanel> panelList;

    private FileHandler handler;

    private JFrame frame;

    private JPanel mainPanel;
	private JPanel leftPanel;
	private JPanel addPanel;

	private JLabel addLabel;

    private JScrollPane scroll;

    public static Color gray = new Color(40, 40, 40);
	public static Color darkGray = new Color(30, 30, 30);
	public static Color whiteGray = new Color(60, 60, 60);
	public static Color darkerWhite = new Color(240, 240, 240);

    public GUI(FileHandler handler) {
        this.handler = handler;
		panelList = new ArrayList<>();
        frame = new JFrame("To-do List");
        mainPanel = new JPanel();
		leftPanel = new JPanel();
		addPanel = new JPanel();
		addLabel = new JLabel();
        scroll = new JScrollPane(mainPanel);

        frame.setResizable(false);
        arrange();
        frame.setSize(705, 390);
        frame.setSize(714, 400);
		frame.requestFocus();
    }

    private void arrange() {
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setBounds(500, 100, 700, 400);
		frame.setLayout(null);

        mainPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 0, 0));
        mainPanel.setBackground(gray);

		leftPanel.setBackground(gray);
		leftPanel.setBounds(0, 0, 100, 400);
		leftPanel.setLayout(null);
		frame.add(leftPanel);

		addPanel.setBounds(25, 140, 50, 50);
		addPanel.setBackground(whiteGray);
		addPanel.setLayout(null);
		addPanel.addMouseListener(new AddPanelHighlighter(addPanel));
		leftPanel.add(addPanel);

		addLabel.setText("+");
		addLabel.setFont(new Font("SansSerif", Font.PLAIN, 65));
		addLabel.setBounds(6, -1, 50, 50);
		addLabel.setForeground(darkerWhite);
		addPanel.add(addLabel);

        scroll.setBounds(100, 0, 600, 400);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(50);

        ArrayList<Node> list = handler.getNodeList();
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			TodoPanel panel = new TodoPanel(node.description(), node.deadline(), node.clock());
			panelList.add(panel);
			mainPanel.add(panel);
		}
        
        frame.add(scroll);
		frame.addWindowListener(new OnCloseListener(handler, frame, panelList));
        frame.setVisible(true);
    }

    public static void initial() {
        JFrame frame = new JFrame();
		frame.setBounds(500, 300, 450, 250);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 50, 50));
		panel.setLayout(new BorderLayout(10, 30));
		frame.add(panel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(new Color(50, 50, 50));
		
		JPanel label1Panel = new JPanel();
		label1Panel.setLayout(new FlowLayout());
		label1Panel.setBackground(new Color(50, 50, 50));
		
		JPanel label2Panel = new JPanel();
		label2Panel.setLayout(new FlowLayout());
		label2Panel.setBackground(new Color(50, 50, 50));
		
		JLabel label1 = new JLabel();
		String possibleText1 = System.getenv("USERPROFILE") + "/todolist.txt";
		String possibleText2 = System.getenv("USERPROFILE") + "\\todolist.txt";
		if (System.getenv("USERPROFILE").contains("\\"))
			label1.setText(possibleText2);
		else
			label1.setText(possibleText1);
		label1.setFont(new Font("SansSerif", Font.PLAIN, 25));
		label1.setForeground(Color.white);
		
		JLabel label2 = new JLabel();
		label2.setText("Veriler bu konumunda saklanacaktir.");
		label2.setFont(new Font("SansSerif", Font.PLAIN, 23));
		label2.setForeground(new Color(180, 180, 180));
		
		JButton button = new JButton();
		button.setText("Tamam");
		button.setPreferredSize(new Dimension(110, 25));
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		label1Panel.add(label1);
		panel.add(label1Panel, BorderLayout.NORTH);
		label2Panel.add(label2);
		panel.add(label2Panel, BorderLayout.CENTER);
		buttonPanel.add(button);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setSize(frame.getWidth() + 1, frame.getHeight());
    }
}