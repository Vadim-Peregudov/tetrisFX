package com.example.testris.model;

import java.util.Random;

public class RandomFigure {
    private static final Random random = new Random();

    public static Figure create() {
        return new Figure(getRandomFigureType());
    }

    public static FigureType getRandomFigureType() {
        int randomValue = random.nextInt(FigureType.MAX_VALUE + 1);
        if (randomValue == FigureType.J.getValue()) {
            return FigureType.J;
        } else if (randomValue == FigureType.I.getValue()) {
            return FigureType.I;
        } else if (randomValue == FigureType.O.getValue()) {
            return FigureType.O;
        } else if (randomValue == FigureType.L.getValue()) {
            return FigureType.L;
        } else if (randomValue == FigureType.Z.getValue()) {
            return FigureType.Z;
        } else if (randomValue == FigureType.T.getValue()) {
            return FigureType.T;
        } else if (randomValue == FigureType.S.getValue()){
            return FigureType.S;
        }
        throw new RuntimeException("This value \"randomValue\" = " + randomValue + ", is not a valid ");
    }
}
