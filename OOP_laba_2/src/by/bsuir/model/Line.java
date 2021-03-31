package by.bsuir.model;

import by.bsuir.MainStage;
import by.bsuir.Point;
import javafx.scene.shape.MoveTo;

import by.bsuir.Main;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.Path;

public class Line extends Figure {
    protected Point twoPoint;

    public Line(Point onePoint, Point twoPoint) {
        super(onePoint);
        this.twoPoint = twoPoint;
    }

    @Override
    public void draw() {
        Path path = new Path();
        MoveTo moveTo = new MoveTo(onePoint.getX(),onePoint.getY());
        LineTo lineTo = new LineTo(twoPoint.getX(),twoPoint.getY());
        path.getElements().addAll(moveTo,lineTo);
        MainStage.group.getChildren().add(path);
    }
}
