package Interactions.SphereCreator;

import Interactions.ErrorScreen;
import Interactions.PanelInteract;
import Interactions.Wizard;
import RayTrasing.GeneralStuff.Vector3;
import RayTrasing.Things.Sphere;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SphereWizard extends Wizard {
    int size = 300;

    PanelInteract manager;

    ArrayList<JTextField> inputs = new ArrayList<>();

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
        inputs.add(posXT);

        this.add(new JLabel("Y: "));
        JTextField posYT = new JTextField(5);
        this.add(posYT);
        inputs.add(posYT);

        this.add(new JLabel("Z: "));
        JTextField posZT = new JTextField(5);
        this.add(posZT);
        inputs.add(posZT);

        this.add(new JLabel(("radius")));
        JTextField radiusT = new JTextField(5);
        this.add(radiusT);
        inputs.add(radiusT);

        this.add(new JLabel("reflectivity"));
        JTextField reflectivityT = new JTextField((5));
        this.add(reflectivityT);
        inputs.add(reflectivityT);


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


        this.add(new Confirmation(this));

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

            for(int i = 0; i < color.length; i++){
                color[i] = Integer.parseInt(inputs.get(i+5).getText());
            }


        }catch (Exception e){
            new ErrorScreen();
            return;
        }

        manager.addThin(new Sphere(new Vector3(position[0], position[1], position[2]), radius, reflectivity, new Vector3(color[0], color[1], color[2])));

    }

}
