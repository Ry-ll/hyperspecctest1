package me.oevy.gui.components;

import me.oevy.features.modules.Module;
import me.oevy.gui.theme.PurpleTheme;
import me.oevy.util.FontUtil;
import me.oevy.util.RenderUtil;

public class ModuleButton extends Button {

    private final Module module;

    public ModuleButton(Module module) {
        this.module = module;
        this.height = 14;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        super.draw(mouseX, mouseY);

        RenderUtil.drawRoundedRect(
                x, y, width, height, 6,
                module.isEnabled()
                        ? PurpleTheme.PRIMARY.getRGB()
                        : PurpleTheme.PANEL.getRGB()
        );

        FontUtil.drawString(
                module.getName(),
                x + 6,
                y + 4,
                module.isEnabled()
                        ? PurpleTheme.TEXT_ACTIVE.getRGB()
                        : PurpleTheme.TEXT.getRGB()
        );
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (hovered && button == 0) {
            module.toggle();
        }
    }
}

        return this.module.isEnabled();
    }
}
