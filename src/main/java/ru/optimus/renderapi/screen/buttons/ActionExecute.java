package ru.optimus.renderapi.screen.buttons;

@FunctionalInterface
public interface ActionExecute<T, E> {
    void apply(T action, E value);
}
