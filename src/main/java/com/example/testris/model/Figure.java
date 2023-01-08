package com.example.testris.model;

public class Figure {
    private static final int SIZE_FIGURE = 5;
    private static final int SIZE_CELL_FIGURE = 4;
    private FigureType type;
    private Cell[][] figure;

    public Figure(FigureType type) {
        this.type = type;
        figure = createFigure(type);
    }

    private Cell[][] createFigure(FigureType type) {
        Cell[][] figure = null;
        switch (type) {
            case I -> figure = createFigureI(type);
            case J -> figure = createFigureJ(type);
            case L -> figure = createFifureL(type);
            case O -> figure = createFigureO(type);
            case Z -> figure = createFigureZ(type);
            case T -> figure = createFigureT(type);
            case S -> figure = createFigureS(type);
        }
        return figure;
    }

    private Cell[][] createFigureS(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure + Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell2 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell cell4 = new Cell(xFigure - Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, cell2, cell1, null},
                {null, cell4, cell3, null, null},
                {null, null, null, null, null}};
        return figure;
    }

    private Cell[][] createFigureT(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 3, type.getColor());
        Cell cell2 = new Cell(xFigure - Field.CELL_SIZE * 1, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell4 = new Cell(xFigure + Field.CELL_SIZE * 1, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, null, null, null},
                {null, null, cell1, null, null},
                {null, cell2, cell3, cell4, null},
                {null, null, null, null, null},
                {null, null, null, null, null}};
        return figure;
    }

    private Cell[][] createFigureZ(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure - Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell2 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell cell4 = new Cell(xFigure + Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, cell1, cell2, null, null},
                {null, null, cell3, cell4, null},
                {null, null, null, null, null}};
        return figure;
    }

    private Cell[][] createFigureO(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure + Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell2 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell cell4 = new Cell(xFigure + Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, cell2, cell1, null},
                {null, null, cell3, cell4, null},
                {null, null, null, null, null}};
        return figure;
    }

    private Cell[][] createFifureL(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 3, type.getColor());
        Cell cell2 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell cell4 = new Cell(xFigure + Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, null, null, null},
                {null, null, cell1, null, null},
                {null, null, cell2, null, null},
                {null, null, cell3, cell4, null},
                {null, null, null, null, null}};
        return figure;
    }

    private Cell[][] createFigureJ(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 3, type.getColor());
        Cell cell2 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell cell4 = new Cell(xFigure - Field.CELL_SIZE, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, null, null, null},
                {null, null, cell1, null, null},
                {null, null, cell2, null, null},
                {null, cell4, cell3, null, null},
                {null, null, null, null, null}};
        return figure;
    }

    private Cell[][] createFigureI(FigureType type) {
        int xFigure = Field.CELL_SIZE * 5;
        Cell cell1 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 4, type.getColor());
        Cell cell2 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 3, type.getColor());
        Cell cell3 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE * 2, type.getColor());
        Cell cell4 = new Cell(xFigure, Field.FIELD_START_Y - Field.CELL_SIZE, type.getColor());
        Cell[][] figure = new Cell[][]{
                {null, null, cell1, null, null},
                {null, null, cell2, null, null},
                {null, null, cell3, null, null},
                {null, null, cell4, null, null},
                {null, null, null, null, null}};
        return figure;
    }

    public FigureType getType() {
        return type;
    }

    public void setType(FigureType type) {
        this.type = type;
    }

    public Cell[][] getFigure() {
        return figure;
    }

    public void setFigure(Cell[][] figure) {
        this.figure = figure;
    }


    public void rotateClockWiseNinetyDegree() {
        figure = rotateClockWise();
        updateFigure();
    }

    public Cell[][] getFuturePositionRotatedFigure() {
        Cell[][] newFigure = new Cell[SIZE_FIGURE][SIZE_FIGURE];
        for (int i = 0; i < SIZE_FIGURE; i++) {
            for (int j = 0; j < SIZE_FIGURE; j++) {
                Cell newCell = null;
                if (figure[i][j] != null) {
                    newFigure[j][SIZE_FIGURE - i - 1] = figure[i][j].clone();
                    newCell = newFigure[j][SIZE_FIGURE - i - 1];
                } else {
                    newFigure[j][SIZE_FIGURE - i - 1] = figure[i][j];
                    newCell = newFigure[j][SIZE_FIGURE - i - 1];
                }
                if (newCell != null) {
                    newCell.setY(newCell.getY() + (j - i) * Field.CELL_SIZE);
                    newCell.setX(newCell.getX() + (SIZE_FIGURE - i - j - 1) * Field.CELL_SIZE);
                }
            }
        }
        return newFigure;
    }
    private Cell[][] rotateClockWise() {
        Cell[][] newFigure = new Cell[SIZE_FIGURE][SIZE_FIGURE];
        for (int i = 0; i < SIZE_FIGURE; i++) {
            for (int j = 0; j < SIZE_FIGURE; j++) {
                newFigure[j][SIZE_FIGURE - i - 1] = figure[i][j];
                Cell newCell = newFigure[j][SIZE_FIGURE - i - 1];
                if (newCell != null) {
                    newCell.setY(newCell.getY() + (j - i) * Field.CELL_SIZE);
                    newCell.setX(newCell.getX() + (SIZE_FIGURE - i - j - 1) * Field.CELL_SIZE);
                }
            }
        }
        return newFigure;
    }


    public void rotateCounterClockWiseNinetyDegree() {
        figure = rotateClockWise();
        figure = rotateClockWise();
        figure = rotateClockWise();
        updateFigure();
    }

    public void moveFigureDown() {
        for (Cell[] cells : figure) {
            for (Cell value : cells) {
                if (value != null) {
                    value.setY(value.getY() + Field.CELL_SIZE);
                }
            }
        }
        updateFigure();
    }

    public void moveFigureRight() {
        for (Cell[] cells : figure) {
            for (Cell value : cells) {
                if (value != null) {
                    value.setX(value.getX() + Field.CELL_SIZE);
                }
            }
        }
        updateFigure();
    }

    public void moveFigureLeft() {
        for (Cell[] cells : figure) {
            for (Cell value : cells) {
                if (value != null) {
                    value.setX(value.getX() - Field.CELL_SIZE);
                }
            }
        }
        updateFigure();
    }

    public void updateFigure() {
        for (Cell[] cells : figure) {
            for (Cell value : cells) {
                if (value != null) {
                    value.updateCell();
                }
            }
        }
    }


    public Cell[] getArrayFigure() {
        Cell[] cells = new Cell[SIZE_CELL_FIGURE];
        int count = 0;
        for (Cell[] figureCells : figure) {
            for (Cell cell : figureCells) {
                if (cell != null) {
                    cells[count++] = cell;
                }
            }
        }
        return cells;
    }
}
