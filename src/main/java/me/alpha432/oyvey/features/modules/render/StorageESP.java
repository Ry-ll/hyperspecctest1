package me.hyperspecctest1.features.modules.visual;

import me.hyperspecctest1.features.modules.Module;
import me.hyperspecctest1.event.events.Render3DEvent;
import me.hyperspecctest1.util.RenderUtil;
import me.hyperspecctest1.features.setting.Setting;
import net.minecraft.tileentity.*;
import java.awt.Color;

public class StorageESP extends Module {

    private final Setting<Boolean> chests = register(new Setting("Chests", true));
    private final Setting<Boolean> shulkers = register(new Setting("Shulkers", true));
    private final Setting<Boolean> enderchests = register(new Setting("EnderChests", true));
    
    public StorageESP() {
        super("StorageESP", "Highlights storage blocks", Category.VISUAL, true, false, false);
    }

    @Override
    public void onRender3D(Render3DEvent event) {
        if (mc.world == null || mc.player == null) return;

        for (TileEntity tile : mc.world.loadedTileEntityList) {
            if (tile instanceof TileEntityChest && chests.getValue()) {
                RenderUtil.drawBlockBox(tile.getPos(), new Color(255, 160, 0, 150), true, true);
            } 
            else if (tile instanceof TileEntityShulkerBox && shulkers.getValue()) {
                RenderUtil.drawBlockBox(tile.getPos(), new Color(255, 0, 100, 150), true, true);
            }
            else if (tile instanceof TileEntityEnderChest && enderchests.getValue()) {
                RenderUtil.drawBlockBox(tile.getPos(), new Color(120, 0, 255, 150), true, true);
            }
        }
    }
}
