package by.bsuir.model;

import by.bsuir.Draw;
import by.bsuir.Point;

public abstract class Figure implements Draw {
    protected Point onePoint;

    Figure(Point onePoint){
        this.onePoint = onePoint;
    }

    @Override
    public void draw() {
        System.out.println("Необходимо уточнее о фигуре");
    }
}
