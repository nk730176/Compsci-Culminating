// CrossyRoad.java
// Created by: N. Kirillov
// Dec 18 2024
// The main File for the Crossy road game where the button interactions are
package hellofx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CrossyRoad extends Application{

    Image logo = new Image("https://assets.stickpng.com/thumbs/580b57fcd9996e24bc43c2ae.png");

    
    //making arraylists for the roads and cars
    ArrayList<Rectangle> roads = new ArrayList<Rectangle>();
    ArrayList<Rectangle> cars = new ArrayList<Rectangle>();

    //initilizing the stage for the pop up for the instructions
    Stage pop = new Stage();
    Group rootpop = new Group();
    Scene popscene = new Scene(rootpop, 250, 100);

    //the starting method for the GUI
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.GREEN);

        //Making the roads and checking if they overlap
        int i = 0;
        int temp = 0;
        while(i<5){
            MyRec rect = new MyRec(900, 90);
            temp = 0;
            for (int j = 0; j<roads.size();j++)
            {
                if (roads.get(j).getY() == rect.getY())
                {
                    temp = 1;
                    break;
                }
            }
            if (temp != 1)
            {
                roads.add(rect);
                i++;
            }
        }

        //adding the roads to the group
        root.getChildren().addAll(roads);

        //creating the chicken/player and adding it to the group
        Chicken player = new Chicken(90,80);
        root.getChildren().add(player.getRect());

        //creating the cars on the road and adding it to the group
        for (int j = 0; j<roads.size();j++)
            {
                Car car = new Car(roads.get(j).getY(), player);
                cars.add(car.getRect()); 
            }
        root.getChildren().addAll(cars);

        //adding the mouse interaction
        click(scene, player);

        //creating the play again button with its function and adding it to the group
        Button butt = new Button("Play Again!");
        restart(butt, primaryStage);
        root.getChildren().add(butt);

        //creating the instructions button to say the mechanics of the game
        Button buttHelp = new Button("Instructions");
        buttHelp.setLayoutX(810);
        buttHelp.setLayoutY(0);
        Instructions(buttHelp);
        root.getChildren().add(buttHelp);

        //setting the stage up and adding everything
        primaryStage.setWidth(900);
        primaryStage.setHeight(940);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Crossy Road");
        primaryStage.getIcons().add(logo);
        primaryStage.show();
    }

    //main method
    public static void main(String[] args) {
        launch(args);
    }

    //adding the mouse click interaction between the chicken
    private void click(Scene scene, Chicken player)
    {
        scene.setOnMouseClicked(e -> {
            if (!player.getCollide())
            {
                player.move();
            }
        }); 
    }

    //adding the interaction component of the button
    private void restart(Button butt, Stage primaryStage)
    {
        butt.setOnMouseClicked( e ->
        {
            primaryStage.close();
            Platform.runLater( () -> new CrossyRoad().start( new Stage() ) );
        } );
        primaryStage.setScene( new Scene( new StackPane( butt ) ) ); 
    }

    //adding the instruction information
    private void Instructions(Button buttHelp)
    {
        buttHelp.setOnMouseClicked( e ->
        {
        rootpop.getChildren().add(new Text(10,50,"Your Goal is to reach the End!!!\nTo move forward you must click with the \nmouse and avoid the moving cars."));
        pop.setScene(popscene);
        pop.setTitle("Instructions");
        pop.show();
        } );
    }
}
