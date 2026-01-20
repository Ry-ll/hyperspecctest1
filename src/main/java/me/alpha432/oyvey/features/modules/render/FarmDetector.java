package me.hyperspecctest1.features.modules.donut;

import me.hyperspecctest1.features.modules.Module;
import me.hyperspecctest1.features.setting.Setting;
import me.hyperspecctest1.features.command.Command;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.BlockPos;
import java.util.HashSet;
import java.util.Set;

public class FarmDetector extends Module {

    private final Setting<Integer> range = register(new Setting("Range", 64, 10, 128));
    private final Setting<Integer> threshold = register(new Setting("KelpThreshold", 10, 1, 50));
    private final Set<BlockPos> announced = new HashSet<>();

    public FarmDetector() {
        super("FarmDetector", "Detects Kelp, Smokers and Crafters", Category.DONUT, true, false, false);
    }

    @Override
    public void onUpdate() {
        if (mc.level == null || mc.player == null) return;
        if (mc.player.tickCount % 40 != 0) return;

        BlockPos playerPos = mc.player.blockPosition();
        int r = range.getValue();
        
        int kelpFound = 0;
        int smokersFound = 0;
        int craftersFound = 0;

        for (int x = -r; x < r; x++) {
            for (int y = -r; y < r; y++) {
                for (int z = -r; z < r; z++) {
                    BlockPos pos = playerPos.offset(x, y, z);
                    Block block = mc.level.getBlockState(pos).getBlock();

                    if (block == Blocks.KELP || block == Blocks.KELP_PLANT) {
                        kelpFound++;
                    } else if (block == Blocks.SMOKER) {
                        smokersFound++;
                    } else if (block == Blocks.CRAFTER) {
                        craftersFound++;
                    }

                    if (kelpFound >= threshold.getValue() || smokersFound > 0 || craftersFound > 0) {
                        if (announced.add(pos)) {
                            Command.sendMessage("Farm Block Detected: " + block.getName().getString() + " at " + pos.toShortString());
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onEnable() {
        announced.clear();
    }
}
