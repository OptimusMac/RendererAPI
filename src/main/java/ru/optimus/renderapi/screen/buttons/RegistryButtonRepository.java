package ru.optimus.renderapi.screen.buttons;

import ru.optimus.renderapi.screen.ModifyGuiScreen;

@FunctionalInterface
public interface RegistryButtonRepository<T extends ModifyButton<? extends ModifyGuiScreen>> {
    void registry(T... value);
}
