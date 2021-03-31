package by.bsuir.model;

import by.bsuir.MainStage;
import by.bsuir.Point;
import javafx.scene.paint.Color;

public class Circle extends Figure {
    protected double radX;

    public Circle(Point onePoint, double radX){
        super(onePoint);
        this.radX = radX;
    }

    @Override
    public void draw(){
        javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(this.onePoint.getX(),this.onePoint.getY(),radX);
        circle.setFill(Color.GRAY);
        MainStage.group.getChildren().add(circle);
    }
}
