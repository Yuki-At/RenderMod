package net.kunmc.lab.rendermod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Pre event)
    {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL)
            return;

        System.out.println("RenderGameOverlayEvent");

        FontRenderer fr = Minecraft.getInstance().fontRenderer;
        fr.drawStringWithShadow("Test!!!", 20, 20, 0xffffffff);
    }

}
