package by.bsuir;

import by.bsuir.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import java.util.ArrayList;


public class Main extends Application {
    public static Group group = new Group();

    public static void main(String[] args)  {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Figure line = new Line(new Point(100,100),new Point(200,200));
        Figure rectangle = new Rectangle(new Point(250,250),100,50);
        Figure triangle = new Triangle(new Point(500,120),new Point(600,300),new Point(450,150));
        Figure square = new Square(new Point(150,700),50);
        Figure circle = new Circle(new Point(650,200),50);
        Figure ellipse = new Ellipse(new Point(500,500),150,50);

        LinkedList<Figure> linkedList = new LinkedList<>();
        linkedList.addFigure(line);
        linkedList.addFigure(rectangle);
        linkedList.addFigure(triangle);
        linkedList.addFigure(square);
        linkedList.addFigure(circle);
        linkedList.addFigure(ellipse);

        for(int i = 0; i < linkedList.getSize(); i++){
            linkedList.getFigure(i).draw();
        }

        Scene scene = new Scene(group,800,800);
        stage.setScene(scene);
        stage.show();

    }
}
