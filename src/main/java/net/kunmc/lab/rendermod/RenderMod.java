package net.kunmc.lab.rendermod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(value = RenderMod.MOD_ID)
public class RenderMod {

    public static final String MOD_ID = "rendermod";

    public RenderMod() {
        MinecraftForge.EVENT_BUS.register(new Events());
    }

}
