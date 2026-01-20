package me.hyperspecctest1.features.modules.donut;

import me.hyperspecctest1.features.modules.Module;
import me.hyperspecctest1.features.command.Command;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class TunnelFinder extends Module {

    public TunnelFinder() {
        super("TunnelFinder", "Scans for player-made tunnels", Category.DONUT, true, false, false);
    }

    @Override
    public void onUpdate() {
        if (mc.player == null || mc.world == null) return;
        if (mc.player.ticksExisted % 20 != 0) return;

        int radius = 25;
        BlockPos playerPos = mc.player.getPosition();

        for (int x = -radius; x < radius; x++) {
            for (int y = -5; y < 10; y++) {
                for (int z = -radius; z < radius; z++) {
                    BlockPos pos = playerPos.add(x, y, z);
                    
                    if (mc.world.getBlockState(pos).getBlock() == Blocks.AIR &&
                        mc.world.getBlockState(pos.up()).getBlock() == Blocks.AIR &&
                        mc.world.getBlockState(pos.down()).getBlock() != Blocks.AIR) {
                        
                        if (mc.world.getBlockState(pos.east()).getBlock() == Blocks.NETHERRACK ||
                            mc.world.getBlockState(pos.west()).getBlock() == Blocks.NETHERRACK) {
                            Command.sendMessage("Tunnel detected at: " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ());
                        }
                    }
                }
            }
        }
    }
}
