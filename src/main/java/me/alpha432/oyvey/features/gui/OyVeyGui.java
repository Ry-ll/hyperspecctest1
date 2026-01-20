package me.oevy.gui;

import me.oevy.gui.theme.PurpleTheme;
import me.oevy.util.RenderUtil;
import net.minecraft.client.gui.GuiScreen;

public class OyVeyGui extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        RenderUtil.drawRect(
                0, 0, width, height,
                PurpleTheme.BACKGROUND.getRGB()
        );

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
