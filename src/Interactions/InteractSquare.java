package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InteractSquare extends JPanel implements MouseListener {



    public InteractSquare(String text, int val, PanelInteract manager){

        this.add(new JLabel(text));
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
