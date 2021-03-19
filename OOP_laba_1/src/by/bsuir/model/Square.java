package by.bsuir.model;

import by.bsuir.Main;
import by.bsuir.Point;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Square extends Figure{
    protected double width;

    public Square(Point onePoint, double width){
        super(onePoint);
        this.width = width;
    }

    @Override
    public void draw(){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(onePoint.getX(),onePoint.getY());
        LineTo lineTo_1 = new LineTo(onePoint.getX()+width,onePoint.getY());
        LineTo lineTo_2 = new LineTo(onePoint.getX()+width,onePoint.getY()+width);
        LineTo lineTo_3 = new LineTo(onePoint.getX(),onePoint.getY()+width);
        LineTo lineTo_4 = new LineTo(onePoint.getX(),onePoint.getY());
        path.getElements().addAll(moveTo,lineTo_1,lineTo_2,lineTo_3,lineTo_4);
        Main.group.getChildren().add(path);
    }
}
