package ru.optimus.renderapi.screen.buttons;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import ru.optimus.renderapi.EdgeInsets;
import ru.optimus.renderapi.GLInstructions;
import ru.optimus.renderapi.Position;
import ru.optimus.renderapi.screen.ModifyGuiScreen;

public class TestScreen extends ModifyGuiScreen {


    public TestScreen(EntityPlayer player, int startGuiIndex) {
        super(player, startGuiIndex);
    }

    public TestScreen(EntityPlayer player) {
        super(player);
    }


    @Override
    public void modifyDrawScreen(int mouseX, int mouseY, float particleTicks) {
        super.modifyDrawScreen(mouseX, mouseY, particleTicks);

        int x = normalizePosX();
        int y = normalizePosY();

        registerForce(new TestButton(x, y, 80, 80, this, (action, button) -> {
            if (action == Action.HOVER) {
                int xPos = button.xPosition;
                int yPos = button.yPosition;

                getRenderAPI().drawQuad(
                        Position.of(xPos, yPos),
                        EdgeInsets.of(button.width, button.height),
                        0x45000000,
                        GLInstructions.empty()
                );
            }else{
                int xPos = button.xPosition;
                int yPos = button.yPosition;

                getRenderAPI().drawQuad(
                        Position.of(xPos, yPos),
                        EdgeInsets.of(button.width, button.height),
                        0xFF000000,
                        GLInstructions.empty()
                );
            }
        }));



    }

}
