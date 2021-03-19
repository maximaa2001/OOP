package by.bsuir.model;

import by.bsuir.Main;
import by.bsuir.Point;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Triangle extends Line {
    protected Point threePoint;

    public Triangle(Point onePoint, Point twoPoint, Point threePoint){
        super(onePoint,twoPoint);
        this.threePoint = threePoint;
    }

    @Override
    public void draw(){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(onePoint.getX(),onePoint.getY());
        LineTo lineTo_1 = new LineTo(twoPoint.getX(),twoPoint.getY());
        LineTo lineTo_2 = new LineTo(threePoint.getX(),threePoint.getY());
        LineTo lineTo_3 = new LineTo(onePoint.getX(),onePoint.getY());
        path.getElements().addAll(moveTo,lineTo_1,lineTo_2,lineTo_3);
        Main.group.getChildren().add(path);
    }
}
