package com.example.testris.model;

import javafx.scene.paint.Color;

public enum FigureType {
    J(Color.rgb(0, 0, 255), 0),
    I(Color.rgb(96, 255, 203), 1),

    O(Color.rgb(255, 252, 0), 2),

    L(Color.rgb(255, 168, 0), 3),

    Z(Color.rgb(255, 0, 0), 4),

    T(Color.rgb(184, 0, 255), 5),

    S(Color.rgb(0, 255, 0), 6);

    private final Color color;
    private final int value;
    public static final int MAX_VALUE = 6;

    FigureType(Color color, int value) {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }



}
