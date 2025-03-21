package ru.optimus.renderapi;


import java.awt.*;

public interface IRenderAPI {


    void drawQuad(Position position, EdgeInsets edgeInsets, Color color, GLInstructions glInstructions);
    void drawQuad(Position position,EdgeInsets edgeInsets, int color, GLInstructions glInstructions);
    void drawQuad(Position position,int x, int y, Color color, GLInstructions glInstructions);
    void drawQuad(Position position,int x, int y, int color, GLInstructions glInstructions);
}
