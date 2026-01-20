package me.oevy.gui.components.settings;

import me.oevy.features.settings.Setting;
import me.oevy.gui.components.Button;
import me.oevy.gui.theme.PurpleTheme;
import me.oevy.util.RenderUtil;

public class Slider extends Button {

    private final Setting<Number> setting;

    public Slider(Setting<Number> setting) {
        this.setting = setting;
        this.height = 10;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        RenderUtil.drawRoundedRect(x, y, width, height, 3, PurpleTheme.OUTLINE.getRGB());

        float percent = setting.getValue().floatValue() /
                setting.getMax().floatValue();

        RenderUtil.drawRoundedRect(
                x, y, width * percent, height, 3,
                PurpleTheme.PRIMARY.getRGB()
        );
    }
}
