package Interactions.Wizards;

import Interactions.PanelInteract;
import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.Sphere;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SphereWizard extends Wizard {


    PanelInteract manager;

    ArrayList<JTextField> inputs = new ArrayList<>();

    public SphereWizard(PanelInteract manager){

        this.manager = manager;

        this.setTitle("Sphere wizard");
        this.setBounds(100, 100, 500, 300);
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

        this.add(new JLabel(""));

        this.add(new JLabel(("radius")));
        JTextField radiusT = new JTextField(5);
        this.add(radiusT);
        inputs.add(radiusT);

        this.add(new JLabel("reflectivity"));
        JTextField reflectivityT = new JTextField((5));
        this.add(reflectivityT);
        inputs.add(reflectivityT);

        this.add(new JLabel(""));
        this.add(new JLabel(""));

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

        int[] position = new int[3];
        float radius;
        float reflectivity;
        int[] color = new int[3];
        try{
            for(int i = 0; i < position.length; i++){
                position[i] = Integer.parseInt(inputs.get(i).getText());
            }

            radius = Float.parseFloat(inputs.get(3).getText());

            reflectivity = Float.parseFloat((inputs.get(4).getText()));

            if (reflectivity > 1 || reflectivity < 0){
                throw new Exception("Invalid reflectivity (must be between 0 and 1)");
            }

            for(int i = 0; i < color.length; i++){
                color[i] = Integer.parseInt(inputs.get(i+5).getText());
                if (color[i] < 0 || color[i] > 255){
                    throw new Exception("Invalid color (must be between 0 and 255)");
                }
            }


        }catch (Exception e){
            new ErrorScreen(e);
            return;
        }

        manager.addThin(new Sphere(new Vector3(position[0], position[1], position[2]), radius, reflectivity, new Vector3(color[0], color[1], color[2])));
        this.setVisible(false);

    }

}
