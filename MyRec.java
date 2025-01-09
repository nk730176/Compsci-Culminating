// MyRec.java
// Created by: N. Kirillov
// Dec 18 2024
// creating the roads where the cars travel
package hellofx;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class MyRec extends Rectangle{
    
    Image image = new Image("https://media.istockphoto.com/id/1042084638/photo/asphalt-texture-background.jpg?s=612x612&w=0&k=20&c=2pv8igIyvV2O_OE4jzr2CanEJmQsjum8stE_oIo5RS0=");

    //constructor to make the roads for the cars
    public MyRec(double width, double height) {
		super(width, height);
        int rand = (int)(Math.random()*7)*90 + 90;
		setY(rand);
        setX(0); 
		setFill(new ImagePattern(image));
	}
}
