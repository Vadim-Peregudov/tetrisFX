package com.example.testris.model;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell implements Cloneable{
    public static final int SIZE = 40;
    public static final int STROKE_WIDTH = 3;
    private static final int ARC_RECTANGLE = 0;
    private static final Color STROKE_COLOR = Color.BLACK;
    private double x;
    private double y;
    private Rectangle rectangle;
    public Cell (){
    }

    public Cell(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        rectangle = initViewCell(color);
    }


    private Rectangle initViewCell(Color color) {
        Rectangle rectangle = new Rectangle(x, y, SIZE, SIZE);
        rectangle.setFill(color);
        rectangle.setStroke(STROKE_COLOR);
        rectangle.setStrokeWidth(STROKE_WIDTH);
        rectangle.setArcHeight(ARC_RECTANGLE);
        rectangle.setArcWidth(ARC_RECTANGLE);
        return rectangle;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void updateCell() {
        Platform.runLater(() -> {
            rectangle.setY(y);
            rectangle.setX(x);
        });
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", rectangle=" + rectangle +
                '}';
    }

    @Override
    public Cell clone() {
        Cell cell = new Cell();
        cell.setY(y);
        cell.setX(x);
        return cell;
    }
}
