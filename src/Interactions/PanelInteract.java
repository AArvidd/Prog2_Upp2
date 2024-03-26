package Interactions;

import RayTrasing.Camera;
import RayTrasing.GeneralStuff.Vector3;
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
        this.getContentPane().setBackground(Color.red);

        this.setVisible(true);

    }

    public void CreateNew(int choice){
        switch (choice){
            //case 0 -> TODO make a system to frame a new frame where the spesifications of a thing kan be spesified
        }
    }

    public void addSphere(Vector3 position, float radius, float reflectivity, Vector3 color){
        scene.add(new Sphere(position, radius, reflectivity, color));
    }

}
