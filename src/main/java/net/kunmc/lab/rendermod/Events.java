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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.lwjgl.opengl.GL11;

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

        /*
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
        bufferbuilder.begin(6, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos(x1, y2, z).tex(u1, v2).endVertex();
        bufferbuilder.pos(x2, y2, z).tex(u2, v2).endVertex();
        bufferbuilder.pos(x2, y1, z).tex(u2, v1).endVertex();
        bufferbuilder.pos(x1, y1, z).tex(u1, v1).endVertex();
        bufferbuilder.finishDrawing();
        WorldVertexBufferUploader.draw(bufferbuilder);
        RenderSystem.popAttributes();
         */

        int width = Minecraft.getInstance().getMainWindow().getScaledWidth();
        int height = Minecraft.getInstance().getMainWindow().getScaledHeight();

        double topX;
        double topY;
        double left;
        double right;
        double bottom;

        if (width > height) {
        } else {
        }

        topX = width / 2.0;
        topY = height / 2.0 - topX * 0.87;
        left = 0.0;
        right = (double) width;
        bottom = height / 2.0 + topX * 0.87;

        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        RenderSystem.pushTextureAttributes();
        RenderSystem.disableTexture();
        RenderSystem.enableBlend();
        RenderSystem.disableAlphaTest();
        RenderSystem.defaultBlendFunc();
        // RenderSystem.shadeModel(GL11.GL_FLAT);
        RenderSystem.shadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.getInstance();
        buffer.begin(5, DefaultVertexFormats.POSITION_COLOR);
        buffer.pos(topX,  topY, 0.0).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex(); // top
        buffer.pos(left, bottom, 0.0).color(0.0f, 1.0f, 0.0f, 0.5f).endVertex(); // left
        buffer.pos(right, bottom, 0.0).color(0.0f, 0.0f, 1.0f, 0.5f).endVertex(); // right
        tessellator.draw();
        // buffer.finishDrawing();
        // WorldVertexBufferUploader.draw(buffer);
        RenderSystem.popAttributes();

        FontRenderer fr = Minecraft.getInstance().fontRenderer;
        fr.drawStringWithShadow("Test!!!", 20, 20, getColor(255, 255, 0, 0));
    }

}
