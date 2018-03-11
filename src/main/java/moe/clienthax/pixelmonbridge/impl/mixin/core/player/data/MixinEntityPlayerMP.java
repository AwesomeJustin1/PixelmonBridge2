package moe.clienthax.pixelmonbridge.impl.mixin.core.player.data;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.common.mixin.core.entity.player.MixinEntityPlayer;

import java.util.List;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(value = EntityPlayerMP.class, priority = 1111)
public abstract class MixinEntityPlayerMP extends MixinEntityPlayer {

    @Inject(method = "supplyVanillaManipulators", at = @At("RETURN"), remap = false)
    public void supplyVanillaManipulators(List<DataManipulator<?, ?>> manipulators, CallbackInfo callbackInfo) {
        get(MutablePartyPokemonData.class).ifPresent(manipulators::add);
    }



}
