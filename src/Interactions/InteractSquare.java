package Interactions;

import Interactions.SphereCreator.SphereWizard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InteractSquare extends JPanel implements MouseListener {

    int choice;
    PanelInteract manager;

    public InteractSquare(String text, int choice, PanelInteract manager){

        this.choice = choice;
        this.manager = manager;

        this.add(new JLabel(text));
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (choice){
            case 1: new SphereWizard(manager);
        }
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
