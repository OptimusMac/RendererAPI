package ru.optimus.renderapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EdgeInsets {

    private int width;
    private int height;

    public static EdgeInsets of(int width, int height) {
        return new EdgeInsets(width, height);
    }

    public void all(int edge) throws IllegalAccessException {
        for (Field declaredField : getClass().getDeclaredFields()) {
            declaredField.set(this, edge);
        }
    }

}
