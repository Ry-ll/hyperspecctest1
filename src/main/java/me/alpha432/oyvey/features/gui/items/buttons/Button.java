package me.oevy.gui.components;

import me.oevy.gui.theme.PurpleTheme;
import me.oevy.util.RenderUtil;

public abstract class Button {

    protected float x, y, width, height;
    protected boolean hovered;

    public void draw(int mouseX, int mouseY) {
        hovered = mouseX >= x && mouseX <= x + width &&
                  mouseY >= y && mouseY <= y + height;

        RenderUtil.drawRoundedRect(
                x, y, width, height, 4,
                hovered
                        ? PurpleTheme.PRIMARY_LIGHT.getRGB()
                        : PurpleTheme.PANEL.getRGB()
        );
    }

    public void mouseClicked(int mouseX, int mouseY, int button) {}

    public void keyTyped(char c, int keyCode) {}
}
