package Interactions;

import Interactions.Wizards.PlaneWizard;
import Interactions.Wizards.SphereWizard;

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
        switch (choice) {
            case 0 -> manager.run();
            case 1 -> new SphereWizard(manager);
            case 2 -> new PlaneWizard(manager);
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
