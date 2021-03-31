package by.bsuir.model;

import by.bsuir.Main;
import by.bsuir.MainStage;
import by.bsuir.Point;
import javafx.scene.paint.Color;

public class Ellipse extends Circle {
    protected double radY;

    public Ellipse(Point onePoint, double radX, double radY){
        super(onePoint,radX);
        this.radY = radY;
    }

    @Override
    public void draw(){
        javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse(onePoint.getX(),onePoint.getY(),radX,radY);
        ellipse.setFill(Color.GRAY);
        MainStage.group.getChildren().add(ellipse);
    }
}
