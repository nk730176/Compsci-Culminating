// Chicken.java
// Created by: N. Kirillov
// Dec 18 2024
// Creating the playable character
package hellofx;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Chicken extends Shape{

    //initilizing variables
    private double dy = -10;
    private double initialY = 815;
    AnimationTimer timer;
    Image image = new Image("https://assets.stickpng.com/thumbs/580b57fcd9996e24bc43c2ab.png");

    //constructor for the chicken class
    public Chicken(double width, double height)
    {
        rect = new Rectangle(width, height);
        rect.setX(360);
        rect.setY(initialY);
        rect.setFill(new ImagePattern(image));
    }

    //the animation method for how the chicken moves
    public void move()
    {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double y = rect.getY();

                //checking if the chicken has collided to stop it forever
                if (collide)
                {
                    timer.stop();
                }
                else
                {
                    //checking if it reaches the end
                    if (y <= 10 || y >= 820) {
                        result(rect);
                        collide = true;
                        stop();
                    }

                    // Move the Chicken
                    if(initialY-rect.getY()>=90)
                    {
                        stop(); 
                        initialY = rect.getY();
                    }
                    else
                    {
                        rect.setY(y + dy);
                    }
                }
            }
        };
        timer.start(); 
    }

    //method to set the collide value
    public void setCollide(boolean a)
    {
        collide = a;
    }
}
