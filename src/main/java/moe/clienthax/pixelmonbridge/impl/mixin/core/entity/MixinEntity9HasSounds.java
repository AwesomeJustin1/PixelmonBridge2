package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity9HasSounds;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Created by Justin
 */
@Mixin(Entity9HasSounds.class)
public abstract class MixinEntity9HasSounds extends MixinEntity8HoldsItems {
}