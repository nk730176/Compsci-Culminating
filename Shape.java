// Shape.java
// Created by: N. Kirillov
// Dec 18 2024
// an abstrect class that Car and Chicken class inherit
package hellofx;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class Shape {

    //values for the abstract class
    Stage pop = new Stage();
    Group root = new Group();
    Scene popscene = new Scene(root, 200, 200);
    Rectangle rect;
    Image image;
    double dx;
    double dy;
    boolean collide = false;

    //the output of the game after reaching the end or crashing
    public void result(Rectangle player)
    {
        if (player.getY()>=20)
        {
            root.getChildren().add(new Text(50,100,"You Lost :( Try Again"));
        }
        else
        {
            root.getChildren().add(new Text(50,100,"You Won!!!"));
        }
        pop.setScene(popscene);
        pop.show();
    }

    //method to get the Rectangle value from the car and chicken classes
    public Rectangle getRect()
    {
        return rect;
    }

    //method to get the collide value
    public boolean getCollide()
    {
        return collide;
    }

    //abstract methods they need to implement
    public abstract void move();
}
