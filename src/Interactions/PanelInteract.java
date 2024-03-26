package Interactions;

import RayTrasing.*;
import RayTrasing.Things.Thing;
import javax.swing.*;
import java.util.ArrayList;


public class PanelInteract extends JFrame {
    int size= 500;

    private Camera main;
    private ArrayList<Thing> scene = new ArrayList<>();

    public PanelInteract(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Frame Exercise 1");
        this.setBounds(100, 100, size, size);
        this.setResizable(false);


    };

}
