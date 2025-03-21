package ru.optimus.renderapi.screen;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import org.omg.CORBA.PUBLIC_MEMBER;
import ru.optimus.renderapi.IRenderAPI;
import ru.optimus.renderapi.RenderAPI;
import ru.optimus.renderapi.screen.buttons.ModifyButton;
import ru.optimus.renderapi.screen.buttons.RegistryButtonRepository;
import ru.optimus.renderapi.utils.ListButtons;

import java.util.Arrays;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ModifyGuiScreen extends GuiScreen {


    private final EntityPlayer player;
    private final int prevGuiIndex;
    private final Minecraft minecraft = Minecraft.getMinecraft();
    private final ListButtons<ModifyButton<ModifyGuiScreen>> modifyButtons = new ListButtons<>();
    private final RegistryButtonRepository<ModifyButton<ModifyGuiScreen>> repository = value -> modifyButtons.addAll(Arrays.asList(value));
    private ScaledResolution resolution;
    private ResolutionSizes resolutionSizes;
    private IRenderAPI renderAPI;

    public ModifyGuiScreen(EntityPlayer player) {
        this(player, Minecraft.getMinecraft().gameSettings.guiScale);
    }

    public ModifyGuiScreen(EntityPlayer player, int startGuiIndex) {
        this.player = player;
        this.prevGuiIndex = minecraft.gameSettings.guiScale;
        this.minecraft.gameSettings.guiScale = startGuiIndex;
        this.resolutionSizes = new ResolutionSizes(this.resolution = new ScaledResolution(minecraft, minecraft.displayWidth, minecraft.displayHeight));
        this.renderAPI = RenderAPI.INSTANCE;
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        this.minecraft.gameSettings.guiScale = prevGuiIndex;
    }

    public int normalizePosX(){
        return getResolution().getScaledWidth() / 2 - normalizeX();
    }

    public int normalizePosY(){
        return getResolution().getScaledHeight() / 2 - normalizeY();
    }


    @Override
    public void drawScreen(int x, int y, float partialTicks) {
        modifyDrawScreen(x, y, partialTicks);

    }

    public void modifyDrawScreen(int mouseX, int mouseY, float particleTicks) {
        this.resolution = this.resolutionSizes.checkResize(this.resolution);
        modifyButtons.renderAllButtons(mouseX, mouseY);


    }

    @SuppressWarnings("unchecked")
    public void registerForce(ModifyButton<ModifyGuiScreen> modifyButton) {
        boolean canRegister = modifyButtons.stream().noneMatch(button -> button.xPosition == modifyButton.xPosition && button.yPosition == modifyButton.yPosition);
        if (canRegister) {
            repository.registry(modifyButton);
        }
    }

    public int normalizeX(){
        int scale = minecraft.gameSettings.guiScale;

        switch (scale){
            case 2:
                return 320;
            case 3:
                return 212;
            case 0:
                return 127;
            case 1:
                return 638;
            default:
                return 0;
        }

    }

    public int normalizeY(){
        int scale = minecraft.gameSettings.guiScale;

        switch (scale){
            case 2:
                return 171;
            case 3:
                return 114;
            case 0:
                return 68;
            case 1:
                return 343;
            default:
                return 0;
        }

    }

}
