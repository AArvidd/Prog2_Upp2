package Interactions.Wizards;

import Interactions.PanelInteract;
import RayTrasing.Camera;
import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.Sphere;
import RayTrasing.Things.Thing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CameraWizard extends Wizard{

    PanelInteract manager;

    ArrayList<JTextField> inputs = new ArrayList<>();

    public CameraWizard(PanelInteract manager){

        this.manager = manager;

        this.setTitle("Camera wizard");
        this.setBounds(100, 100, 750, 300);
        this.setResizable(false);
        this.setLayout(new GridLayout(6,7));
        this.getContentPane().setBackground(Color.red);

        this.add(new JLabel("position"));

        this.add(new JLabel("X: "));
        JTextField posXT = new JTextField(5);
        this.add(posXT);
        inputs.add(posXT);

        this.add(new JLabel("Y: "));
        JTextField posYT = new JTextField(5);
        this.add(posYT);
        inputs.add(posYT);

        this.add(new JLabel("Z: "));
        JTextField posZT = new JTextField(5);
        this.add(posZT);
        inputs.add(posZT);

        this.add(new JLabel("Pixels: "));

        this.add(new JLabel(("X: ")));
        JTextField pixelsX = new JTextField(5);
        this.add(pixelsX);
        inputs.add(pixelsX);

        this.add(new JLabel("Y: "));
        JTextField pixelsY = new JTextField(5);
        this.add(pixelsY);
        inputs.add(pixelsY);

        this.add(new JLabel("<html>Camera width:<br/>(recommended: 2) </html>"));
        JTextField CameraWidth = new JTextField(5);
        this.add(CameraWidth);
        inputs.add(CameraWidth);

        this.add(new JLabel("color"));

        this.add(new JLabel("R: "));
        JTextField R = new JTextField(5);
        this.add(R);
        inputs.add(R);

        this.add(new JLabel("G: "));
        JTextField G = new JTextField(5);
        this.add(G);
        inputs.add(G);

        this.add(new JLabel("B: "));
        JTextField B = new JTextField(5);
        this.add(B);
        inputs.add(B);


        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));


        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new Confirmation(this));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));


        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.setVisible(true);

    }

    public void reade(){

        float[] position = new float[3];
        int pixelsX;
        int  pixelsY;
        float width;
        int[] color = new int[3];
        try{
            for(int i = 0; i < position.length; i++){
                position[i] = Integer.parseInt(inputs.get(i).getText());
            }

            pixelsX = Integer.parseInt(inputs.get(3).getText());
            pixelsY = Integer.parseInt(inputs.get(4).getText());

            if(pixelsX <= 0 || pixelsY <= 0){
                throw new Exception("Invalid pixel width (must be more than 0)");
            }

            width = Float.parseFloat(inputs.get(5).getText());

            if(width <= 0){
                throw new Exception("Invalid width (must be mor than 0)");
            }

            for(int i = 0; i < color.length; i++){
                color[i] = Integer.parseInt(inputs.get(i+6).getText());
                if (color[i] < 0 || color[i] > 255){
                    throw new Exception("Invalid color (must be between 0 and 255)");
                }
            }


        }catch (Exception e){
            new ErrorScreen(e);
            return;
        }

        manager.addCamera(new Camera(
                new Vector3(position[0], position[1], position[2]),
                pixelsX, pixelsY, width,
                new ArrayList<>(),
                new Vector3(color[0], color[1], color[2])
        ));
        this.setVisible(false);

    }

}
