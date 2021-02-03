package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
    Created by Ivan
    in 03/02/2021
    Description:
*/
public class Pong extends Application {

    public static Circle bola1;
    public static Pane canvas;
    public static Rectangle pala1,pala2;

    @Override
    public void start(final Stage primaryStage) {

        canvas = new Pane();

        final Scene escena = new Scene(canvas, 1000, 600, Color.BLACK);
        final Bounds limits = canvas.getBoundsInLocal();
        primaryStage.setTitle("Bolla Rebotant");
        primaryStage.setScene(escena);
        primaryStage.show();

        int radi=15;
        bola1 = new Circle(radi, Color.WHITE);
        bola1.setLayoutX(limits.getMaxX()/2);
        bola1.setLayoutY(limits.getMaxY()/2);


        pala1=new Rectangle(20,100,Color.WHITE);
        pala1.relocate(20, limits.getMaxY()/2-50);

        pala2=new Rectangle(20,100,Color.WHITE);
        pala2.relocate(limits.getMaxX()-40, limits.getMaxY()/2-50);

        canvas.getChildren().addAll(bola1);
        canvas.getChildren().addAll(pala1,pala2);


        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {


            // Formula en radians
            //double deltaX = 3*Math.cos(Math.PI/3);
            //double deltaY = 3*Math.sin(Math.PI/3);

            // Formula en graus
            double angle_en_radians =Math.toRadians(30);
            int velocitat=3;
            double deltaX = velocitat*Math.cos(angle_en_radians);
            double deltaY = velocitat*Math.sin(angle_en_radians);

            @Override
            public void handle(final ActionEvent t) {

                bola1.setLayoutX(bola1.getLayoutX() + deltaX);
                bola1.setLayoutY(bola1.getLayoutY() + deltaY);



                final boolean alLimitDret = bola1.getLayoutX() >= (limits.getMaxX() - bola1.getRadius());
                final boolean alLimitEsquerra = bola1.getLayoutX() <= (limits.getMinX() + bola1.getRadius());
                final boolean alLimitInferior = bola1.getLayoutY() >= (limits.getMaxY() - bola1.getRadius());
                final boolean alLimitSuperior = bola1.getLayoutY() <= (limits.getMinY() + bola1.getRadius());


                if (alLimitDret || alLimitEsquerra) {

                    deltaX *= -1;
                }
                if (alLimitInferior || alLimitSuperior) {

                    deltaY *= -1;
                }
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
