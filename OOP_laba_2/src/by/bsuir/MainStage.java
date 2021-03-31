package by.bsuir;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import by.bsuir.model.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainStage {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btn_line;

    @FXML
    private Button btn_triangle;

    @FXML
    private Button btn_circle;

    @FXML
    private Button btn_ellipse;

    @FXML
    private Button btn_square;

    @FXML
    private Button btn_rectangle;

    @FXML
    private Label text_field;


    public static Group group = new Group();
    private Stage stage = Main.mainStage;
    private Deque<Point> deque = new LinkedList<>();

    Figure figure;



    EventHandler<MouseEvent> mouse_anchor_pane = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            deque.addLast(new Point(event.getSceneX(), event.getSceneY()));
        }
    };

    @FXML
    void initialize() {
        anchorPane.addEventHandler(MouseEvent.MOUSE_CLICKED,mouse_anchor_pane);
            btn_line.setOnMouseClicked(event -> {
                try {
                    figure = new Line(deque.removeLast(), deque.removeLast());
                    drawFigure();
                }catch (NoSuchElementException e){
                    text_field.setText("Недостаточно точек");
                }
            });

            btn_triangle.setOnMouseClicked(event -> {
                try {
                    figure = new Triangle(deque.removeLast(), deque.removeLast(), deque.removeLast());
                    drawFigure();
                }catch (NoSuchElementException e){
                    text_field.setText("Недостаточно точек");
                }
            });
            btn_circle.setOnMouseClicked(event -> {
                try {
                    double radX = Math.abs(deque.removeLast().getX() - deque.getLast().getX());
                    figure = new Circle(deque.removeLast(), radX);
                    drawFigure();
                }catch (NoSuchElementException e){
                    text_field.setText("Недостаточно точек");
                }
            });
            btn_ellipse.setOnMouseClicked(event -> {
                try {
                    Point rY = deque.removeLast();
                    Point rX = deque.removeLast();
                    Point center = deque.removeLast();
                    double radY = Math.abs(rY.getY() - center.getY());
                    double radX = Math.abs(rX.getX() - center.getX());
                    figure = new Ellipse(center, radX, radY);
                    drawFigure();
                }catch (NoSuchElementException e){
                    text_field.setText("Недостаточно точек");
                }
            });

            btn_square.setOnMouseClicked(event -> {

                try {
                    double width = Math.abs(deque.removeLast().getX() - deque.getLast().getX());
                    figure = new Square(deque.removeLast(), width);
                    drawFigure();
                }catch (NoSuchElementException e){
                    text_field.setText("Недостаточно точек");
                }
            });

            btn_rectangle.setOnMouseClicked(event -> {
                try {
                    Point rY = deque.removeLast();
                    Point rX = deque.removeLast();
                    Point angle = deque.removeLast();
                    double height = Math.abs(rY.getY() - angle.getY());
                    double width = Math.abs(rX.getX() - angle.getX());
                    figure = new Rectangle(angle, width, height);
                    drawFigure();
                }catch (NoSuchElementException e){
                    text_field.setText("Недостаточно точек");
                }
            });
    }

    private void drawFigure(){
        group = new Group();
        figure.draw();
        anchorPane.getChildren().add(group);
        stage.show();
        text_field.setText("");
    }
}
