package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.UUID;

/**
 * Created by clienthax on 10/03/2018.
 */
public interface MutableComputerTileEntityData extends DataManipulator<MutableComputerTileEntityData, ImmutableComputerTileEntityData> {

    OptionalValue<UUID> owner();
    Value<DyeColor> color();
    Value<Boolean> raveMode();

}
