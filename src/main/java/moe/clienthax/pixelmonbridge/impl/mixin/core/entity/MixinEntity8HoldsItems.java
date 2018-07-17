package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity8HoldsItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by Justin
 */
@Mixin(Entity8HoldsItems.class)
public abstract class MixinEntity8HoldsItems extends MixinEntity7HasAI {
    @Shadow
    public int numInteractions;
}