package ru.optimus.renderapi.screen.buttons;

import ru.optimus.renderapi.screen.ModifyGuiScreen;

@FunctionalInterface
public interface ActionFunction {

    void action(Action action, ModifyGuiScreen modifyGuiScreen);
}
