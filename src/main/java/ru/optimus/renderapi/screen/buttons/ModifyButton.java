package ru.optimus.renderapi.screen.buttons;

import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.input.Mouse;
import ru.optimus.renderapi.IRenderAPI;
import ru.optimus.renderapi.RenderAPI;
import ru.optimus.renderapi.screen.ModifyGuiScreen;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Getter
public abstract class ModifyButton<T extends ModifyGuiScreen> extends GuiButton {

    private final T root;
    private final IRenderAPI renderAPI;
    private BiConsumer<Action, ModifyButton<T>> actionConsumer;

    private final ActionExecute<Action, ModifyButton<T>> actionFunction = (action, button) -> {
        if (actionConsumer != null)
            actionConsumer.accept(action, button);
    };
    private long controlButtonClick = System.currentTimeMillis();
    private boolean canPressed = true;

    public ModifyButton(int x, int y, int width, int height, T root) {
        super(-1, x, y, width, height, "");
        this.root = root;
        this.id = root.getModifyButtons().indexOf(this);
        this.renderAPI = RenderAPI.INSTANCE;
    }

    public ModifyButton(int x, int y, int width, int height, T root, BiConsumer<Action, ModifyButton<T>> actionConsumer) {
        this(x, y, width, height, root);
        this.actionConsumer = actionConsumer;
    }


    public boolean checkHover(int mouseX, int mouseY) {
        return mouseX >= this.xPosition + getRoot().normalizeX() + 3 && mouseX <= this.xPosition + getRoot().normalizeX() + this.width + 3 &&
                mouseY >= this.yPosition + getRoot().normalizeY() && mouseY < this.yPosition + getRoot().normalizeY() + this.height;
    }

    @Override
    public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_) {

        if(Mouse.isButtonDown(0)){
            if(checkHover(p_146116_2_, p_146116_3_) && controlButtonClick < System.currentTimeMillis() && canPressed){
                this.actionConsumer.accept(Action.CLICK, this);
                this.controlButtonClick = System.currentTimeMillis() + 100;
                this.canPressed = false;
                return true;
            }
        }else {
            this.canPressed = true;
            return false;
        }
        return false;

    }



    @Override
    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
        this.drawButton(p_146112_2_, p_146112_3_);


    }

    public void change(Consumer<ModifyButton<T>> modifier) {
        modifier.accept(this);
    }


    public void drawButton(int mouseX, int mouseY) {
        this.mousePressed(Minecraft.getMinecraft(), mouseX, mouseY);
        if (checkHover(mouseX, mouseY)) {
            actionConsumer.accept(Action.HOVER, this);
        }
    }
}
