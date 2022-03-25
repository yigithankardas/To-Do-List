package gui.highlights;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddPanelHighlighter implements MouseListener {

    private JPanel panel;
    private Color color;
    private Color colorLight;
    private Color colorDark;

    public AddPanelHighlighter(JPanel panel) {
        this.panel = panel;
        colorLight = new Color(80, 80, 80);
        colorDark = new Color(30, 30, 30);
        color = panel.getBackground();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        panel.setBackground(colorDark);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        panel.setBackground(color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        panel.setBackground(colorLight);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        panel.setBackground(color);
    }
}