package com.example.testris.model;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;

import java.util.LinkedList;

public class QueueFigure {
    private static final int START_X = 415;
    private static final int START_Y_CELL_1 = 100;
    private static final int START_Y_CELL_2 = 270;
    private static final int START_Y_CELL_3 = 440;

    private LinkedList<FigureType> queueFigures;
    private Figure cell_1;
    private Figure cell_2;
    private Figure cell_3;
    private ObservableList<Node> list;

    public QueueFigure(ObservableList<Node> list) {
        this.list = list;
        queueFigures = new LinkedList<>();
        createQueueFigures();
        createFigureView();
        setView();
    }

    private void setView() {
        viewCell(cell_1);
        viewCell(cell_2);
        viewCell(cell_3);
    }

    private void viewCell(Figure figure) {
        Platform.runLater(() -> {
            for (Cell cell : figure.getArrayFigure()) {
                list.add(cell.getRectangle());
            }
        });
    }

    private void createFigureView() {
        cell_1 = new Figure(queueFigures.get(0));
        setPositionView(cell_1, START_Y_CELL_1);
        cell_2 = new Figure(queueFigures.get(1));
        setPositionView(cell_2, START_Y_CELL_2);
        cell_3 = new Figure(queueFigures.get(2));
        setPositionView(cell_3, START_Y_CELL_3);
    }

    private void setPositionView(Figure figure, int startY) {
        var cells = figure.getFigure();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j] != null) {
                    Cell cell = cells[i][j];
                    cell.setX(START_X + Field.CELL_SIZE * j);
                    cell.setY(startY + Field.CELL_SIZE * i);
                    cell.updateCell();
                }
            }
        }
    }

    private void createQueueFigures() {
        for (int i = 0; i < 3; i++) {
            queueFigures.addLast(RandomFigure.getRandomFigureType());
        }
    }

    public FigureType getFirstFigure() {
        var figureType = queueFigures.getFirst();

        queueFigures.removeFirst();
        queueFigures.addLast(RandomFigure.getRandomFigureType());

        deleteViewFigure(cell_1);
        updateFigure();
        updateViewFigure();
        viewCell(cell_3);

        return figureType;
    }

    private void updateViewFigure() {
        setPositionView(cell_1, START_Y_CELL_1);
        setPositionView(cell_2, START_Y_CELL_2);
        setPositionView(cell_3, START_Y_CELL_3);
    }

    private void updateFigure() {
        cell_1 = cell_2;
        cell_2 = cell_3;
        cell_3 = new Figure(queueFigures.getLast());
    }


    private void deleteViewFigure(Figure figure) {
        Platform.runLater(() -> {
            for (Cell cell : figure.getArrayFigure()) {
                list.remove(cell.getRectangle());
            }
        });
    }

    public LinkedList<FigureType> getQueueFigures() {
        return new LinkedList<>(queueFigures);
    }

    public Figure getCell_1() {
        return cell_1;
    }

    public Figure getCell_2() {
        return cell_2;
    }

    public Figure getCell_3() {
        return cell_3;
    }
}
