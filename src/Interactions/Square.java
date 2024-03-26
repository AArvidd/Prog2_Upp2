package Interactions;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {

    public Square(int posX, int posY, int sizeX, int sizeY, Color color){


        this.setBounds(posX, posY, sizeX, sizeY);
        this.setBackground(color);

    }

}
