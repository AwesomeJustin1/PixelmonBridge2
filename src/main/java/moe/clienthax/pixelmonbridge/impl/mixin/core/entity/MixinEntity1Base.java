package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.Entity1Base;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.common.SpongeImpl;
import org.spongepowered.common.mixin.core.entity.MixinEntityLiving;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(Entity1Base.class)
public abstract class MixinEntity1Base extends MixinEntityLiving {

    @Shadow(remap = false)
    public abstract String getPokemonName();//Only works on captured pokemon? seems pixelmon doesnt populate the name for wilds?

    @Shadow(remap = false)
    public abstract EnumPokemon getSpecies();

}
