package gui.listeners;

import gui.*;

import javax.swing.*;

import fileio.FileHandler;
import fileio.FileHandler.Node;

import java.awt.event.*;
import java.util.ArrayList;

public class OnCloseListener extends WindowAdapter {

    private FileHandler handler;
    private JFrame frame;
    private ArrayList<TodoPanel> list;
    private ArrayList<Node> nodeList;

    public OnCloseListener(FileHandler handler, JFrame frame, ArrayList<TodoPanel> list) {
        this.handler = handler;
        this.frame = frame;
        this.list = list;
        this.nodeList = handler.getNodeList();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        for (int i = 0; i < list.size(); i++) {
            TodoPanel panel = list.get(i);
            for (int j = 0; j < panel.getComponentCount(); j++) {
                if (panel.getComponent(j) instanceof JPanel) {
                    boolean exit = false;
                    JPanel innerPanel = (JPanel)panel.getComponent(j);
                    for (int k = 0; k < innerPanel.getComponentCount(); k++) {
                        if (innerPanel.getComponent(k) instanceof JTextField) {
                            nodeList.get(i).setDescription(((JTextField)innerPanel.getComponent(k)).getText());
                            exit = true;
                            break;
                        }
                    }
                    if (exit)
                        break;
                }
            }
        }
        handler.output();
        frame.dispose();
    }
}