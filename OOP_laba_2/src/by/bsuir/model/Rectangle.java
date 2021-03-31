package by.bsuir.model;


import by.bsuir.Main;
import by.bsuir.MainStage;
import by.bsuir.Point;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Rectangle extends Square {
    protected double height;

    public Rectangle(Point onePoint, double width, double height) {
        super(onePoint,width);
        this.height = height;
    }

    @Override
    public void draw(){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(onePoint.getX(),onePoint.getY());
        LineTo lineTo_1 = new LineTo(onePoint.getX()+width,onePoint.getY());
        LineTo lineTo_2 = new LineTo(onePoint.getX()+width, onePoint.getY() + height);
        LineTo lineTo_3 = new LineTo(onePoint.getX(), onePoint.getY() + height);
        LineTo lineTo_4 = new LineTo(onePoint.getX(),onePoint.getY());
        path.getElements().addAll(moveTo,lineTo_1,lineTo_2,lineTo_3,lineTo_4);
        MainStage.group.getChildren().add(path);
    }
}
