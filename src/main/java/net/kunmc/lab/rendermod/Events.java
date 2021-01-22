package net.kunmc.lab.rendermod;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.TransformationMatrix;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    public int getColor(int alpha, int red, int green, int blue) {
        return alpha << 24 | red << 16 | green << 8 | blue;
    }

    @SubscribeEvent
    public void onRenderPre(final RenderGameOverlayEvent.Pre event) {

    }

    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent.Post event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }

        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();
        buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(TransformationMatrix.identity().getMatrix(), 0.0f, 3.4f, 0.0f).color(0, 255, 0, 255).endVertex();
        buffer.pos(TransformationMatrix.identity().getMatrix(), 4.0f, 3.4f, 0.0f).color(0, 0, 255, 255).endVertex();
        buffer.pos(TransformationMatrix.identity().getMatrix(), 2.0f, 0.0f, 0.0f).color(255, 0, 0, 255).endVertex();
        buffer.finishDrawing();
        RenderSystem.enableAlphaTest();
        WorldVertexBufferUploader.draw(buffer);
        RenderSystem.enableTexture();
        RenderSystem.disableBlend();

        FontRenderer fr = Minecraft.getInstance().fontRenderer;
        fr.drawStringWithShadow("Test!!!", 20, 20, getColor(255, 255, 0, 0));
    }

}
