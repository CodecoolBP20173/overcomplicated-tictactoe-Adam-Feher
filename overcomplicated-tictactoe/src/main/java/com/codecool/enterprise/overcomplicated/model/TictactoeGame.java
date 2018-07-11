package com.codecool.enterprise.overcomplicated.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TictactoeGame {
    public List<Field> board;

    public TictactoeGame() {
        board = Arrays.asList(Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY, Field.EMPTY);
    }

    public void setField(int fieldNumber, Field field) {
        board.set(fieldNumber, field);
    }

    public Field getField(int fieldNumber) {
        return board.get(fieldNumber);
    }

    public char[] getBoardAsCharArray() {
        char[] boardCharArray = new char[9];
        for (int i = 0; i < 9; i++) {
            Field current = this.getField(i);
            if (current == Field.CIRCLE) {
                boardCharArray[i] = 'O';
            } else if (current == Field.X) {
                boardCharArray[i] = 'X';
            } else {
                boardCharArray[i] = '-';
            }
        }
        return boardCharArray;
    }

    public boolean isThereAFreeField() {
        for (Field field : board) {
            if (field == Field.EMPTY) {
                return true;
            }
        }
        return false;
    }
}