package me.oevy.gui.components.settings;

import me.oevy.features.settings.Setting;
import me.oevy.gui.components.Button;
import me.oevy.gui.theme.PurpleTheme;
import me.oevy.util.FontUtil;
import me.oevy.util.RenderUtil;

public class EnumButton extends Button {

    private final Setting<Enum<?>> setting;

    public EnumButton(Setting<Enum<?>> setting) {
        this.setting = setting;
        this.height = 12;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        RenderUtil.drawRoundedRect(
                x, y, width, height, 4,
                PurpleTheme.PRIMARY.getRGB()
        );

        FontUtil.drawString(
                setting.getName() + ": " + setting.getValue().name(),
                x + 4,
                y + 3,
                PurpleTheme.TEXT_ACTIVE.getRGB()
        );
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (hovered && button == 0) {
            setting.nextEnum();
        }
    }
}
