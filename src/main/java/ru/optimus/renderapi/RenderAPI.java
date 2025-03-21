package ru.optimus.renderapi;


import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class RenderAPI implements IRenderAPI {

    public static IRenderAPI INSTANCE = new RenderAPI();

    @Override
    public void drawQuad(Position position, EdgeInsets edgeInsets, int color, GLInstructions glInstructions) {

        GL11.glPushMatrix();
        GL11.glTranslated(position.getX(), position.getY(), 0);
        GL11.glColor4f(1, 1, 1, 1);
        glInstructions.enableAll();
        Gui.drawRect(position.getX(), position.getY(), position.getX() + edgeInsets.getWidth(), position.getY() + edgeInsets.getHeight(), color);
        glInstructions.flush();
        GL11.glPopMatrix();

    }

    @Override
    public void drawQuad(Position position, EdgeInsets edgeInsets, Color color, GLInstructions glInstructions) {
        drawQuad(position, edgeInsets, color.getRGB(), glInstructions);
    }

    @Override
    public void drawQuad(Position position, int x, int y, Color color, GLInstructions glInstructions) {
        drawQuad(position, EdgeInsets.of(x, y), color.getRGB(), glInstructions);
    }

    @Override
    public void drawQuad(Position position, int x, int y, int color, GLInstructions glInstructions) {
        drawQuad(position, EdgeInsets.of(x, y), color, glInstructions);

    }

}
