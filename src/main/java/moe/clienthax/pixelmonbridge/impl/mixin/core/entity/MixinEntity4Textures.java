package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity4Textures;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Created by Justin
 */
@Mixin(Entity4Textures.class)
public abstract class MixinEntity4Textures extends MixinEntity3HasStats {
}