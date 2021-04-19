package by.bsuir;

import java.io.Serializable;
import java.time.LocalDate;

public class Way implements Serializable {
    private String fromPoint;
    private String toPoint;

    public Way(){}
    public Way(String fromPoint, String toPoint) {
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
    }

    public String getFromPoint() {
        return fromPoint;
    }

    public String getToPoint() {
        return toPoint;
    }

    public void setFromPoint(String fromPoint) {
        this.fromPoint = fromPoint;
    }

    public void setToPoint(String toPoint) {
        this.toPoint = toPoint;
    }
}
