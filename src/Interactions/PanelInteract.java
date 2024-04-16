package Interactions;

import RayTrasing.Camera;
import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.MainSystem;
import RayTrasing.Things.Sphere;
import RayTrasing.Things.Thing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PanelInteract extends JFrame {
    private int size= 500;

    ArrayList<Thing> scene = new ArrayList<>();
    Camera main;

    public PanelInteract(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Ray tracing setup");
        this.setBounds(100, 100, size, size);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        this.add(new InteractSquare("Create Sphere", 1, this));
        this.add(new InteractSquare("Create Plane", 2, this));
        this.add(new InteractSquare("Run program", 0, this));
        this.getContentPane().setBackground(Color.red);

        this.setVisible(true);

    }

    public void addThin(Thing thing){
        scene.add(thing);
    }

    public void run(){
        this.setVisible(false);
        MainSystem main = new MainSystem(scene);
        new ResultScreen(main.getImage());
    }

}
