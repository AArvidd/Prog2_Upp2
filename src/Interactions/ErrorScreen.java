package Interactions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ErrorScreen extends JFrame implements MouseListener {

    private int size = 300;

    public ErrorScreen(){
        this.setTitle("Error");
        this.setBounds(500, 300, size, size);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.red);

        this.add(new JLabel("only numbers are permitted"));

        this.addMouseListener(this);

        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.setVisible(false);
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
