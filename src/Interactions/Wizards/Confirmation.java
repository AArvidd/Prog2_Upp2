package Interactions.Wizards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//this class is the button to take in the information in the wizards
public class Confirmation extends JPanel implements MouseListener {

    Wizard frame;

    //constructor
    public Confirmation(Wizard frame){
        this.frame = frame;

        this.add(new JLabel("Confirm"));
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        frame.reade();
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
