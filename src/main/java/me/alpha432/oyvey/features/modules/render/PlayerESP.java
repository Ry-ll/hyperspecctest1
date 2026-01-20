package me.hyperspecctest1.features.modules.visual;

import me.hyperspecctest1.features.modules.Module;
import me.hyperspecctest1.event.events.Render3DEvent;
import me.hyperspecctest1.util.RenderUtil;
import net.minecraft.entity.player.EntityPlayer;
import java.awt.Color;

public class PlayerESP extends Module {

    public PlayerESP() {
        super("PlayerESP", "Draws boxes around players", Category.VISUAL, true, false, false);
    }

    @Override
    public void onRender3D(Render3DEvent event) {
        if (mc.world == null) return;

        for (EntityPlayer player : mc.world.playerEntities) {
            if (player == mc.player) continue;
            RenderUtil.drawEntityBox(player, new Color(255, 255, 255, 100), true);
        }
    }
}
