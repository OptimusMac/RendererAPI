package ru.optimus.renderapi.screen.buttons;

import ru.optimus.renderapi.EdgeInsets;
import ru.optimus.renderapi.GLInstructions;
import ru.optimus.renderapi.Position;
import ru.optimus.renderapi.screen.ModifyGuiScreen;

import java.util.function.BiConsumer;

public class TestButton extends ModifyButton<ModifyGuiScreen> {


    public TestButton(int x, int y, int width, int height, ModifyGuiScreen root, BiConsumer<Action, ModifyButton<ModifyGuiScreen>> actionConsumer) {
        super(x, y, width, height, root, actionConsumer);
    }

    @Override
    public void drawButton(int mouseX, int mouseY) {
        super.drawButton(mouseX, mouseY);

        getRenderAPI().drawQuad(
                Position.of(xPosition, yPosition),
                EdgeInsets.of(width, height),
                0x74FFFFFF,
                GLInstructions.empty());
    }
}
