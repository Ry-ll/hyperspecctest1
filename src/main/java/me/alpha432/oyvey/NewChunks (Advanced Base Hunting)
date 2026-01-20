package me.hyperspecctest1.features.modules.visual;

import me.hyperspecctest1.event.events.PacketEvent;
import me.hyperspecctest1.event.events.Render3DEvent;
import me.hyperspecctest1.features.modules.Module;
import me.hyperspecctest1.util.RenderUtil;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.util.math.ChunkPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class NewChunks extends Module {

    private final Set<ChunkPos> newChunks = HashSet::new;

    public NewChunks() {
        super("NewChunks", "Detects newly generated chunks", Category.VISUAL, true, false, false);
    }

    @SubscribeEvent
    public void onPacketReceive(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketChunkData) {
            SPacketChunkData packet = (SPacketChunkData) event.getPacket();
            if (!packet.isFullChunk()) {
                ChunkPos pos = new ChunkPos(packet.getChunkX(), packet.getChunkZ());
                newChunks.add(pos);
            }
        }
    }

    @Override
    public void onRender3D(Render3DEvent event) {
        if (mc.world == null) return;

        for (ChunkPos chunk : newChunks) {
            RenderUtil.drawChunkBox(chunk, new Color(255, 0, 0, 100));
        }
    }

    @Override
    public void onDisable() {
        newChunks.clear();
    }
}
