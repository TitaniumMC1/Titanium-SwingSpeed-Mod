package net.titanium.swingspeedchanger.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import eu.midnightdust.lib.config.MidnightConfig;
import net.titanium.swingspeedchanger.Main;

/**
 * Registers a ModMenu button that opens the MidnightLib config screen.
 *
 * <p>Created by titanium, updated to 1.21.1.</p>
 */
public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> MidnightConfig.getScreen(parent, Main.MOD_ID);
    }
}
