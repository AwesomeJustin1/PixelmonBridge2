package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.entities.pixelmon.Entity2HasModel;
import com.pixelmonmod.pixelmon.enums.EnumPokemon;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Created by Justin
 */
@Mixin(Entity2HasModel.class)
public abstract class MixinEntity2HasModel extends MixinEntity1Base {
    @Shadow
    public boolean transformed;

    @Shadow
    public abstract void evolve(PokemonSpec evolveTo);

    @Shadow
    public abstract void transformServer(EnumPokemon transformedModel, int transformedForm);

    @Shadow
    public abstract void cancelTransform();

    @Shadow
    public abstract int getTransformed();

    @Shadow
    public abstract float getScaleFactor();
}