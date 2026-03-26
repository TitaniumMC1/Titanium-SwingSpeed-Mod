package net.titanium.swingspeedchanger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.titanium.swingspeedchanger.utils.ConfigManager;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Swing Speed Changer — main entry point.
 *
 * Created by titanium, updated to 1.21.1.
 */
public class Main implements ModInitializer {

    public static final String MOD_ID = "swingspeedchanger";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /** Keybinding that opens the MidnightLib config screen. */
    public static KeyBinding OPEN_CONFIG_KEY;

    @Override
    public void onInitialize() {
        // Initialise MidnightLib config
        eu.midnightdust.lib.config.MidnightConfig.init(MOD_ID, ConfigManager.class);

        // Register the config-screen keybinding (default: none / UNKNOWN)
        OPEN_CONFIG_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "Config screen key",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_UNKNOWN,
                "Swing Speed Changer"
        ));

        // Open config screen when the key is pressed
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (OPEN_CONFIG_KEY.wasPressed()) {
                if (client.currentScreen == null) {
                    client.setScreen(
                            eu.midnightdust.lib.config.MidnightConfig.getScreen(client.currentScreen, MOD_ID)
                    );
                }
            }
        });

        LOGGER.info("The Swing Speed Changer mod has successfully been initialized!");
        LOGGER.info("Mod made with the heart by titanium!");
    }
}
