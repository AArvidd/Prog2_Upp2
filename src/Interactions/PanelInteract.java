package Interactions;

import Interactions.Wizards.ErrorScreen;
import RayTrasing.Camera;
import RayTrasing.MainSystem;
import RayTrasing.Things.Thing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//this class is the panel that lets the user chose what to add and run the ray tracing program
public class PanelInteract extends JFrame {
    private int size= 500;

    ArrayList<Thing> scene = new ArrayList<>();
    Camera camera;

    //constructor
    public PanelInteract(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ray tracing setup");
        this.setBounds(100, 100, size, size);
        this.setResizable(false);
        this.setLayout(new FlowLayout());

        this.add(new InteractSquare("Create Sphere", 2, this));
        this.add(new InteractSquare("Create Plane", 3, this));
        this.add(new InteractSquare("Create Camera", 1, this));
        this.add(new InteractSquare("Run program", 0, this));
        this.getContentPane().setBackground(Color.red);

        this.setVisible(true);

    }

    //ads objects to the scene
    public void addThin(Thing thing){
        scene.add(thing);
    }

    //ads the camera
    public void addCamera(Camera camera){
        this.camera = camera;
    }

    //checks if there exist a camera and run the program
    public void run(){
        if(camera == null){
            new ErrorScreen(new Exception("Camera does not exist"));
            return;
        }
        this.setVisible(false);
        MainSystem main = new MainSystem(scene, camera);
        new ResultScreen(main.getImage());
    }

}
