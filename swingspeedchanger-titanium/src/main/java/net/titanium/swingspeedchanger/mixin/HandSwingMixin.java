package net.titanium.swingspeedchanger.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.LivingEntity;
import net.titanium.swingspeedchanger.utils.ConfigManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin into {@link LivingEntity} to override the hand-swing duration.
 *
 * <p>{@code getHandSwingDuration()} controls how many ticks a full arm
 * swing animation takes. Vanilla returns 6 (or 4 with Haste). We
 * short-circuit that value with whatever the user has configured,
 * without touching any game-logic cooldowns.</p>
 *
 * <p>Created by titanium, updated to 1.21.1.</p>
 */
@Environment(EnvType.CLIENT)
@Mixin(LivingEntity.class)
public abstract class HandSwingMixin {

    /**
     * Injects at the very start of {@code getHandSwingDuration} and,
     * when the mod is enabled, cancels the vanilla return value in
     * favour of the user-configured speed.
     */
    @Inject(
            method = "getHandSwingDuration",
            at = @At("HEAD"),
            cancellable = true
    )
    private void onHandSwing(CallbackInfoReturnable<Integer> cir) {
        if (ConfigManager.enabled) {
            cir.setReturnValue(ConfigManager.speed);
        }
    }
}
