package Interactions.SphereCreator;

import Interactions.PanelInteract;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SphereWizard extends JFrame {
    int size = 300;

    PanelInteract manager;

    ArrayList<JTextField> positionText = new ArrayList<>();

    public SphereWizard(PanelInteract manager){

        this.manager = manager;

        this.setTitle("Sphere wizard");
        this.setBounds(100, 100, size, size);
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.getContentPane().setBackground(Color.red);

        this.add(new JLabel("position"));

        this.add(new JLabel("X: "));
        JTextField posXT = new JTextField(5);
        this.add(posXT);
        positionText.add(posXT);

        this.add(new JLabel("Y: "));
        JTextField posYT = new JTextField(5);
        this.add(posYT);
        positionText.add(posYT);

        this.add(new JLabel("Z: "));
        JTextField posZT = new JTextField(5);
        this.add(posZT);
        positionText.add(posZT);



        this.setVisible(true);
    }

    public void reade(){

        int[] position = new int[3];

        for(int i = 0; i < position.length; i++){
            try{
                position[i] = Integer.valueOf(positionText.get(i).getText());
                System.out.println(position[i]);
            }catch (Exception e){
                System.out.println("inte text");
            }
        }
    }

}
