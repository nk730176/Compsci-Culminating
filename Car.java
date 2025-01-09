// Car.java
// Created by: N. Kirillov
// Dec 18 2024
// creating the obstacle of crossy road
package hellofx;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Car extends Shape{
    //initilizes the variables
    private double dx;
    private double xcore = Math.random()*720;
    AnimationTimer timer;
    private Image image = new Image("https://assets.stickpng.com/thumbs/5c471e37f8ab04028c27e08a.png");
    Chicken player;

    //constructor to make the car
    public Car(double ycore, Chicken player)
    {
        //creates the viewable car
        rect = new Rectangle(180, 80);
        rect.setX(xcore);
        rect.setY(ycore+5);
        rect.setFill(new ImagePattern(image));
        dx = Math.random()*10 + 1;
        setPlayer(player);
        
        //makes the cars move
        move();
    }

    //method to make the cars move
    public void move()
    {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                double x = rect.getX();

                // Check for collisions with walls
                if (x <= 0 || x >= 720) {
                    dx = -dx; // Reverse horizontal direction
                }

                // Move the car
                rect.setX(x + dx);
                collision();

                //checks if the car collided with the chicken and stops the car
                if (getCollide())
                {
                    timer.stop();
                }
            }
        };
        timer.start(); 
    }

    //method to check if the car collided with the chicken
    public void collision()
    {
        if(rect.getBoundsInParent().intersects(player.getRect().getBoundsInParent()))
        {
            collide = true;
            result(player.getRect());
            player.setCollide(collide);
        }
    }

    //method to set the chicken player
    private void setPlayer(Chicken Player)
    {
        this.player = Player;
    }
}
