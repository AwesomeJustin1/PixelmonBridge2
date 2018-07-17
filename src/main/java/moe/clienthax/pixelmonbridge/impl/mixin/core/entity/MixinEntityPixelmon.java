package moe.clienthax.pixelmonbridge.impl.mixin.core.entity;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.items.ItemPixelmonSprite;
import moe.clienthax.pixelmonbridge.api.catalog.pixelmon.PixelmonType;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.*;
import moe.clienthax.pixelmonbridge.api.entity.pixelmon.Pixelmon;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.common.SpongeImpl;

import java.util.List;
import java.util.Optional;

/**
 * Created by clienthax on 10/03/2018.
 */
@Mixin(EntityPixelmon.class)
public abstract class MixinEntityPixelmon extends MixinEntity10CanBreed implements Pixelmon {

    @Override
    public EntityType getType() {
        EntityPixelmon pixelmon = (EntityPixelmon) (Object) this;

        //Sometimes the entity isnt fully constructed (spawners)
        if (pixelmon.getSpecies() == null) {
            return super.getType();
        }

        String name = "pixelmon:" + pixelmon.getSpecies().name;
        Optional<PixelmonType> type = SpongeImpl.getRegistry().getType(PixelmonType.class, name);
        if (type.isPresent()) {
            return type.get();
        } else {
            System.out.println("Missing registry entry for " + name);
        }

        return super.getType();
    }

    @Override
    public void supplyVanillaManipulators(List<DataManipulator<?, ?>> manipulators) {
        super.supplyVanillaManipulators(manipulators);
        get(MutableBaseStatsData.class).ifPresent(manipulators::add);
        get(MutableEVData.class).ifPresent(manipulators::add);
        get(MutableEggData.class).ifPresent(manipulators::add);
        get(MutableNameData.class).ifPresent(manipulators::add);
        get(MutableIVData.class).ifPresent(manipulators::add);
        get(MutableNickNameData.class).ifPresent(manipulators::add);
        get(MutablePokemonIDData.class).ifPresent(manipulators::add);
    }

    @Override
    public ItemStack getPhoto() {
        return (ItemStack) (Object) ItemPixelmonSprite.getPhoto((EntityPixelmon) (Object) this);
    }
}
