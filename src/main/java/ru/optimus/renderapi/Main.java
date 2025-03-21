package ru.optimus.renderapi;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import org.omg.CORBA.PUBLIC_MEMBER;
import ru.optimus.renderapi.screen.buttons.TestScreen;

@Mod(name = "s", modid = "s")
public class Main {


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
    }





    @SubscribeEvent
    public void onOpen(GuiOpenEvent e){
        if(e.gui instanceof GuiInventory){
            Minecraft.getMinecraft().displayGuiScreen(new TestScreen(Minecraft.getMinecraft().thePlayer));
            e.setCanceled(true);
        }
    }

}
