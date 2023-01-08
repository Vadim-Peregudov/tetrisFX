package com.example.testris.model;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {
    public static final int FIELD_START_X = 0;
    public static final int FIELD_START_Y = 0;
    public static final int CELL_SIZE = 40;
    public static final int FIELD_FINISH_X = 360;
    public static final int FIELD_FINISH_Y = 760;
    private boolean[][] cells = new boolean[FIELD_FINISH_Y / CELL_SIZE + 1][FIELD_FINISH_X / CELL_SIZE + 1];
    private ObservableList<Node> field;
    private ArrayList<Figure> figuresField;
    private Figure currentFigure;
    private int completedLine;
    private int score;
    private int scoreCompletedLine;


    public Field(ObservableList<Node> list) {
        field = list;
        figuresField = new ArrayList<>();
        clearCells();
        completedLine = 0;
        score = 0;
        scoreCompletedLine = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void isCheckCompletedLines() {
        if (figuresField.isEmpty()) {
            return;
        }
        for (int i = 0; i < cells.length; i++) {
            boolean statusCompletedLine = true;
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j]) {
                    statusCompletedLine = statusCompletedLine && cells[i][j];
                } else {
                    statusCompletedLine = statusCompletedLine && cells[i][j];
                }
                if (statusCompletedLine && j == cells[i].length - 1) {
                    deleteCompletedLine(i);
                    moveUpperFiguresDown(i);
                    clearCells();
                    createCells();
                    completedLine++;
                    addScoreCompletedLine();
                }
            }
        }
        addScore();
    }

    private void clearScoreCompletedLine() {
        scoreCompletedLine = 0;
    }

    private void addScoreCompletedLine() {
        scoreCompletedLine++;
    }

    private void addScore() {

        if (scoreCompletedLine == 1) {
            score = score + 100;
        } else if (scoreCompletedLine == 2) {
            score = score + 300;
        } else if (scoreCompletedLine == 3) {
            score = score + 800;
        } else if (scoreCompletedLine == 4) {
            score = score + 1400;
        }
        clearScoreCompletedLine();

    }

    private void moveUpperFiguresDown(int i) {
        ArrayList<Cell> upperFigures = new ArrayList<>();
        for (Figure figure : figuresField) {
            for (Cell cells : figure.getArrayFigure()) {
                if (cells != null && cells.getY() < i * CELL_SIZE) {
                    cells.setY(cells.getY() + CELL_SIZE);
                    upperFigures.add(cells);
                }
            }
        }
        for (Cell cell : upperFigures) {
            cell.updateCell();
        }

    }

    private void deleteCompletedLine(int i) {
        ArrayList<Cell> deleteLine = new ArrayList<>();
        for (Figure figure : figuresField) {
            for (Cell cells : figure.getArrayFigure()) {
                if (cells != null && cells.getY() == i * CELL_SIZE) {
                    deleteLine.add(cells);
                }
            }
        }
        for (Figure figure : figuresField) {
            for (int j = 0; j < figure.getFigure().length; j++) {
                for (int k = 0; k < figure.getFigure()[j].length; k++) {
                    if (figure.getFigure()[k][j] != null && deleteLine.contains(figure.getFigure()[k][j])) {
                        figure.getFigure()[k][j] = null;
                    }
                }
            }
        }
        List<Rectangle> deleteRectangle = deleteLine.stream().map(cell -> cell.getRectangle()).toList();
        Platform.runLater(() -> {
            field.removeIf(node -> node instanceof Rectangle && deleteRectangle.contains(node));
        });
    }

    private void createCells() {
        for (Figure figure : figuresField) {
            for (Cell cell : figure.getArrayFigure()) {
                if (cell != null) {
                    double i = cell.getX() / CELL_SIZE;
                    double j = cell.getY() / CELL_SIZE;
                    if (i >= 0 && i <= 9 && j >= 0 && j <= 19) {
                        this.cells[(int) j][(int) i] = true;
                    }
                }
            }
        }
    }

    private void clearCells() {
        for (boolean[] cell : cells) {
            Arrays.fill(cell, false);
        }
    }

    public void addCurrentFigure(Figure figure) {
        currentFigure = figure;
    }

    public void addCurrentFigureToField() {
        figuresField.add(currentFigure);
        createCells();
        currentFigure = null;
    }


    public boolean isCheckMoveCurrentFigureDown() {
        for (Cell cell : currentFigure.getArrayFigure()) {
            if (cell.getY() + CELL_SIZE > FIELD_FINISH_Y) {
                return false;
            }
            if (getValueCellToPoint((int) (cell.getX() / CELL_SIZE), (int) ((cell.getY() + CELL_SIZE) / CELL_SIZE))) {
                return false;
            }
        }
        return true;
    }

    private boolean getValueCellToPoint(int x, int y) {
        if (y >= 0 && y <= 19 && x >= 0 && x <= 9) {
            return cells[y][x];
        } else {
            return false;
        }
    }

    public void moveCurrentFigureDown() {
        currentFigure.moveFigureDown();
    }

    public boolean isCheckMoveCurrentFigureLeft() {
        for (Cell cell : currentFigure.getArrayFigure()) {
            if (cell.getX() - CELL_SIZE < 0) {
                return false;
            }
            if (getValueCellToPoint((int) ((cell.getX() - CELL_SIZE) / CELL_SIZE), (int) ((cell.getY()) / CELL_SIZE))) {
                return false;
            }
        }
        return true;
    }

    public boolean isCheckMoveCurrentFigureRight() {
        for (Cell cell : currentFigure.getArrayFigure()) {
            if (cell.getX() + CELL_SIZE > FIELD_FINISH_X) {
                return false;
            }
            if (getValueCellToPoint((int) ((cell.getX() + CELL_SIZE) / CELL_SIZE), (int) ((cell.getY()) / CELL_SIZE))) {
                return false;
            }
        }
        return true;
    }

    public void moveCurrentFigureRight() {
        currentFigure.moveFigureRight();
    }

    public void moveCurrentFigureLeft() {
        currentFigure.moveFigureLeft();
    }

    public boolean isCheckRotateCurrentFigure() {
        var newPositionFigure = currentFigure.getFuturePositionRotatedFigure();
        for (Cell[] cells : newPositionFigure) {
            for (Cell cell : cells) {
                if (cell != null) {
                    if (cell.getX() > FIELD_FINISH_X) {
                        return false;
                    }
                    if (cell.getX() < 0) {
                        return false;
                    }
                    if (getValueCellToPoint((int) ((cell.getX()) / CELL_SIZE), (int) ((cell.getY()) / CELL_SIZE))) {
                        System.out.println("3");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void rotateCurrentFigure() {
        currentFigure.rotateClockWiseNinetyDegree();
    }

}
