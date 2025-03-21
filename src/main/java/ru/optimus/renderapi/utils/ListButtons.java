package ru.optimus.renderapi.utils;

import ru.optimus.renderapi.GLInstructions;
import ru.optimus.renderapi.screen.ModifyGuiScreen;
import ru.optimus.renderapi.screen.buttons.ModifyButton;

import java.util.ArrayList;
import java.util.Optional;

public class ListButtons<T extends ModifyButton<? extends ModifyGuiScreen>> extends ArrayList<T> {


    public int insertAndGetIndex(T value) {
        this.add(value);
        return indexOf(value);
    }

    public Optional<T> getOptional(int index) {
        return Optional.ofNullable(get(index));
    }

    public Optional<T> getOptional(T value) {
        return Optional.ofNullable(get(indexOf(value)));
    }

    public void renderAllButtons(int x, int y) {
        for (T t : this) {
            t.drawButton(x, y);
        }
    }

    public void renderAllButtons(int x, int y, GLInstructions glInstructions) {
        for (T t : this) {
            glInstructions.enableAll();
            t.drawButton(x, y);
            glInstructions.flush();
        }
    }

    public void register(T value){
        this.add(value);
    }
}
