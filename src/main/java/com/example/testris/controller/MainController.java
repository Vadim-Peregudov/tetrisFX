package com.example.testris.controller;

import com.example.testris.model.Cell;
import com.example.testris.model.Field;
import com.example.testris.model.Figure;
import com.example.testris.model.QueueFigure;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public static final int BASIC_TIME_WAITING = 600;
    public static final int MINIMUM_TIME_WAITING = 250;
    public static long timeWaiting = BASIC_TIME_WAITING;
    @FXML
    public Label valueScore;
    @FXML
    private Pane main;
    private Field field;
    private Figure figure;
    private Stage stage;
    private QueueFigure queue;
    public int count = 0;
    private boolean statusPressedButtonDown = false;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        field = new Field(main.getChildren());
        queue = new QueueFigure(main.getChildren());
    }

    private void execute() {
        count++;
        if (figure == null) {
            updateFigure();
            return;
        }
        if (field.isCheckMoveCurrentFigureDown()) {
            if (!statusPressedButtonDown) {
                field.moveCurrentFigureDown();
            }
            statusPressedButtonDown = false;
        } else {
            field.addCurrentFigureToField();
            figure = null;
            field.isCheckCompletedLines();
            updateScore();
            return;
        }
        updateScore();
    }

    private void updateScore() {
        while (!valueScore.getText().equals(String.valueOf(field.getScore()))) {
            Platform.runLater(() -> {
                valueScore.setText(String.valueOf(field.getScore()));
            });
        }
    }

    private void updateFigure() {
        figure = new Figure(queue.getFirstFigure());
        Platform.runLater(() -> {
            if (field != null) {
                for (Cell cell : figure.getArrayFigure()) {
                    main.getChildren().add(cell.getRectangle());
                }
            }
        });
        field.addCurrentFigure(figure);

    }

    public void start() {
        Runnable runnable = new Runnable() {
            long timeStart = System.currentTimeMillis();
            long timeFinish;
            long timeSleep;

            @Override
            public void run() {
                while (true) {
                    timeFinish = System.currentTimeMillis();
                    if (timeFinish - timeStart >= calcTimeSleep(timeWaiting - (timeFinish - timeStart))) {
                        execute();
                        timeStart = timeFinish;
                    } else {
                        try {
                            timeSleep = calcTimeSleep(timeWaiting - (timeFinish - timeStart));

                            Thread.sleep(timeSleep);

                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

            private long calcTimeSleep(long timeSleep) {
                int time = (int) (timeSleep - field.getScore() / 1000 * 25);
                return Math.max(time, MINIMUM_TIME_WAITING);
            }

        };
        Thread mainTread = new Thread(runnable);
        mainTread.setDaemon(true);
        mainTread.start();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
        stage.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            if (figure != null) {
                if (keyEvent.getCode().equals(KeyCode.D)) {

                    if (field.isCheckMoveCurrentFigureRight()) {
                        field.moveCurrentFigureRight();
                    }

                } else if (keyEvent.getCode().equals(KeyCode.A)) {

                    if (field.isCheckMoveCurrentFigureLeft()) {
                        field.moveCurrentFigureLeft();
                    }

                } else if (keyEvent.getCode().equals(KeyCode.SPACE)) {

                    if (field.isCheckMoveCurrentFigureDown()) {
                        field.moveCurrentFigureDown();
                        statusPressedButtonDown = true;
                    } else {
                        field.addCurrentFigureToField();
                        figure = null;
                        field.isCheckCompletedLines();
                    }

                } else if (keyEvent.getCode().equals(KeyCode.W)) {

                    if (field.isCheckRotateCurrentFigure()) {
                        field.rotateCurrentFigure();
                    }
                } else if (keyEvent.getCode().equals(KeyCode.S)) {

                    while (field.isCheckMoveCurrentFigureDown()) {
                        field.moveCurrentFigureDown();
                    }
                    field.addCurrentFigureToField();
                    figure = null;
                    field.isCheckCompletedLines();

                }
            }
        });
    }
}