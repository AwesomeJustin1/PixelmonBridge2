package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity7HasAI;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Created by Justin
 */
@Mixin(Entity7HasAI.class)
public abstract class MixinEntity7HasAI extends MixinEntity6CanBattle {
}