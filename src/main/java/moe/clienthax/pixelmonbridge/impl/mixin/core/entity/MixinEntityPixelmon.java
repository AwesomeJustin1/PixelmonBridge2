package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableBaseStatsData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEVData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEggData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.player.MutablePartyPokemonData;
import moe.clienthax.pixelmonbridge.api.entity.PixelmonType;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.common.SpongeImpl;
import org.spongepowered.common.mixin.core.entity.MixinEntityLiving;

import java.util.List;
import java.util.Optional;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(EntityPixelmon.class)
public abstract class MixinEntityPixelmon extends MixinEntity3HasStats {

    @Override
    public EntityType getType() {
        EntityPixelmon pixelmon = (EntityPixelmon) (Object) this;

        //Sometimes the entity isnt fully constructed (spawners)
        if(pixelmon.getSpecies() == null) {
            return super.getType();
        }

        String name = "pixelmon:"+pixelmon.getSpecies().name;
        Optional<PixelmonType> type = SpongeImpl.getRegistry().getType(PixelmonType.class, name);
        if (type.isPresent()) {
            return type.get();
        } else {
            System.out.println("Missing registry entry for "+name);
        }

        return super.getType();
    }

    @Override
    public void supplyVanillaManipulators(List<DataManipulator<?, ?>> manipulators) {
        super.supplyVanillaManipulators(manipulators);
        get(MutableBaseStatsData.class).ifPresent(manipulators::add);
        get(MutableEVData.class).ifPresent(manipulators::add);
        get(MutableEggData.class).ifPresent(manipulators::add);
    }

}
