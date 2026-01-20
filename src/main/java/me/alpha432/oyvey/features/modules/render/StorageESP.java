package me.hyperspecctest1.features.modules.visual;

import me.hyperspecctest1.features.modules.Module;
import me.hyperspecctest1.event.events.Render3DEvent;
import me.hyperspecctest1.util.RenderUtil;
import me.hyperspecctest1.features.setting.Setting;
import net.minecraft.world.level.block.entity.*;
import java.awt.Color;

public class StorageESP extends Module {

    private final Setting<Boolean> chests = register(new Setting<>("Chests", true));
    private final Setting<Boolean> shulkers = register(new Setting<>("Shulkers", true));
    private final Setting<Boolean> enderchests = register(new Setting<>("EnderChests", true));
    private final Setting<Boolean> barrels = register(new Setting<>("Barrels", true));
    
    public StorageESP() {
        super("StorageESP", "Highlights storage blocks", Category.VISUAL, true, false, false);
    }

    @Override
    public void onRender3D(Render3DEvent event) {
        if (mc.level == null || mc.player == null) return;

        for (BlockEntity blockEntity : mc.level.blockEntityTickers) {
            
            if (blockEntity instanceof ChestBlockEntity && chests.getValue()) {
                RenderUtil.drawBlockBox(blockEntity.getBlockPos(), new Color(255, 160, 0, 150), true, true);
            } 
            else if (blockEntity instanceof ShulkerBoxBlockEntity && shulkers.getValue()) {
                RenderUtil.drawBlockBox(blockEntity.getBlockPos(), new Color(255, 0, 100, 150), true, true);
            }
            else if (blockEntity instanceof EnderChestBlockEntity && enderchests.getValue()) {
                RenderUtil.drawBlockBox(blockEntity.getBlockPos(), new Color(120, 0, 255, 150), true, true);
            }
            else if (blockEntity instanceof BarrelBlockEntity && barrels.getValue()) {
                RenderUtil.drawBlockBox(blockEntity.getBlockPos(), new Color(150, 75, 0, 150), true, true);
            }
        }
    }
}
