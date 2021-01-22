package net.kunmc.lab.rendermod;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {

    private final ResourceLocation texture = new ResourceLocation(RenderMod.MOD_ID, "textures/gui/star.png");

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

        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 64.0;
        double y2 = 64.0;
        double z = 0.0;
        float u1 = 0.0f;
        float v1 = 0.0f;
        float u2 = 0.3333f;
        float v2 = 1.0f;

        Minecraft.getInstance().getRenderManager().textureManager.bindTexture(texture);

        RenderSystem.pushTextureAttributes();
        RenderSystem.color3f(1.0f, 1.0f, 1.0f);
        RenderSystem.enableBlend();
        RenderSystem.enableAlphaTest();

        BufferBuilder bufferbuilder = Tessellator.getInstance().getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(x1, y2, z).tex(u1, v2).endVertex();
        bufferbuilder.pos(x2, y2, z).tex(u2, v2).endVertex();
        bufferbuilder.pos(x2, y1, z).tex(u2, v1).endVertex();
        bufferbuilder.pos(x1, y1, z).tex(u1, v1).endVertex();
        bufferbuilder.finishDrawing();
        WorldVertexBufferUploader.draw(bufferbuilder);
        RenderSystem.popAttributes();

        FontRenderer fr = Minecraft.getInstance().fontRenderer;
        fr.drawStringWithShadow("Test!!!", 20, 20, getColor(255, 255, 0, 0));
    }

}
