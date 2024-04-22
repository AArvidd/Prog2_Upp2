package Interactions.Wizards;

import Interactions.PanelInteract;
import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.Ground;
import RayTrasing.Things.Sphere;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlaneWizard extends Wizard{

    PanelInteract manager;

    ArrayList<JTextField> inputs = new ArrayList<>();

    public PlaneWizard(PanelInteract manager){

        this.manager = manager;

        this.setTitle("Plane wizard");
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


        this.add(new JLabel("reflectivity"));
        JTextField reflectivityT = new JTextField((5));
        this.add(reflectivityT);
        inputs.add(reflectivityT);

        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.add(new JLabel("color 1"));

        this.add(new JLabel("R1: "));
        JTextField R1 = new JTextField(5);
        this.add(R1);
        inputs.add(R1);

        this.add(new JLabel("G1: "));
        JTextField G1 = new JTextField(5);
        this.add(G1);
        inputs.add(G1);

        this.add(new JLabel("B1: "));
        JTextField B1 = new JTextField(5);
        this.add(B1);
        inputs.add(B1);

        this.add(new JLabel("color 2"));

        this.add(new JLabel("R2: "));
        JTextField R2 = new JTextField(5);
        this.add(R2);
        inputs.add(R2);

        this.add(new JLabel("G2: "));
        JTextField G2 = new JTextField(5);
        this.add(G2);
        inputs.add(G2);

        this.add(new JLabel("B2: "));
        JTextField B2 = new JTextField(5);
        this.add(B2);
        inputs.add(B2);


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

        this.setVisible(true);

    }

    public void reade(){

        float[] position = new float[3];
        float reflectivity;
        int[] color = new int[6];
        try{
            for(int i = 0; i < position.length; i++){
                position[i] = Integer.parseInt(inputs.get(i).getText());
            }

            reflectivity = Float.parseFloat((inputs.get(3).getText()));

            if (reflectivity > 1 || reflectivity < 0){
                throw new Exception("Invalid reflectivity (must be between 0 and 1)");
            }

            for(int i = 0; i < color.length; i++){
                color[i] = Integer.parseInt(inputs.get(i+4).getText());
                if (color[i] < 0 || color[i] > 255){
                    throw new Exception("Invalid color (must be between 0 and 255)");
                }
            }


        }catch (Exception e){
            new ErrorScreen(e);
            return;
        }

        manager.addThin(new Ground(new Vector3(position[0], position[1], position[2]), reflectivity, new Vector3(color[0], color[1], color[2]), new Vector3(color[3], color[4], color[5])));
        this.setVisible(false);

    }

}
