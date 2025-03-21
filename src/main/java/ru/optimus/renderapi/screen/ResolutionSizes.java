package ru.optimus.renderapi.screen;


import lombok.AllArgsConstructor;
import lombok.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

@AllArgsConstructor
@Data
public class ResolutionSizes {

    private int width, height;
    private final Minecraft mc = Minecraft.getMinecraft();

    public ResolutionSizes(ScaledResolution scaledResolution){
        this.width = scaledResolution.getScaledWidth();
        this.height = scaledResolution.getScaledHeight();
    }

    public ScaledResolution checkResize(ScaledResolution scaledResolution){
        if(this.width != scaledResolution.getScaledWidth() || this.height != scaledResolution.getScaledHeight()){
            return new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
        }
        return scaledResolution;
    }
}
