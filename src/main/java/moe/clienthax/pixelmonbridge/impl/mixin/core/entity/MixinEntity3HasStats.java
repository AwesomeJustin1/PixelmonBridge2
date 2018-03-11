package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity1Base;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity3HasStats;
import com.pixelmonmod.pixelmon.entities.pixelmon.stats.BaseStats;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.common.SpongeImpl;
import org.spongepowered.common.mixin.core.entity.MixinEntityLiving;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(Entity3HasStats.class)
public abstract class MixinEntity3HasStats extends MixinEntity1Base {


    @Shadow(remap = false)
    public BaseStats baseStats;



}
