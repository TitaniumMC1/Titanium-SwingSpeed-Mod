package net.titanium.swingspeedchanger.utils;

import eu.midnightdust.lib.config.MidnightConfig;

/**
 * Holds every persistent setting exposed through MidnightLib.
 *
 * <p>Created by titanium, updated to 1.21.1.</p>
 */
public class ConfigManager extends MidnightConfig {

    /** Category label used in the config screen. */
    public static final String SWING_SPEED = "swingspeedchanger.config.settings";

    // ── toggleable ───────────────────────────────────────────────────────────

    /** Whether the custom swing speed is currently active. */
    @Entry(category = SWING_SPEED, name = "swingspeedchanger.config.enabled")
    public static boolean enabled = true;

    // ── speed ────────────────────────────────────────────────────────────────

    /**
     * Swing duration in ticks (lower = faster).
     *
     * <p>Vanilla default is 6. The range 1–20 covers everything from
     * nearly-instant (1 tick) to very slow (20 ticks = 1 second).</p>
     */
    @Entry(category = SWING_SPEED, name = "swingspeedchanger.config.speed",
           min = 1, max = 20)
    public static int speed = 6;
}
