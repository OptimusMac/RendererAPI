package ru.optimus.renderapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Position {

    private int x;
    private int y;

    public static Position of(int x, int y) {
        return new Position(x, y);
    }
}
