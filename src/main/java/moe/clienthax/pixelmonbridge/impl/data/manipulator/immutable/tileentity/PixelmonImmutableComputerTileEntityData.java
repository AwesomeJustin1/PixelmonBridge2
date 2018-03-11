package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.tileentity;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.tileentity.PixelmonMutableComputerTileEntityData;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableData;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.immutable.ImmutableOptionalValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeOptionalValue;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PixelmonImmutableComputerTileEntityData extends AbstractImmutableData<ImmutableComputerTileEntityData, MutableComputerTileEntityData> implements ImmutableComputerTileEntityData {

    final Optional<UUID> owner;
    final DyeColor color;
    final boolean raveMode;

    final ImmutableOptionalValue<UUID> ownerValue;
    final ImmutableValue<DyeColor> colorValue;
    final ImmutableValue<Boolean> raveModeValue;

    public PixelmonImmutableComputerTileEntityData(Optional<UUID> owner, DyeColor color, boolean raveMode) {
        this.owner = owner;
        this.color = color;
        this.raveMode = raveMode;

        this.ownerValue = new ImmutableSpongeOptionalValue<>(PixelmonDataKeys.COMPUTER_OWNER, this.owner);
        this.colorValue = new ImmutableSpongeValue<>(PixelmonDataKeys.COMPUTER_COLOR, this.color);
        this.raveModeValue = new ImmutableSpongeValue<>(PixelmonDataKeys.COMPUTER_RAVE_MODE, this.raveMode);
        registerGetters();
    }

    @Override
    protected void registerGetters() {
        registerFieldGetter(PixelmonDataKeys.COMPUTER_OWNER, () -> this.owner);
        registerKeyValue(PixelmonDataKeys.COMPUTER_OWNER, this::owner);

        registerFieldGetter(PixelmonDataKeys.COMPUTER_COLOR, () -> this.color);
        registerKeyValue(PixelmonDataKeys.COMPUTER_COLOR, this::color);

        registerFieldGetter(PixelmonDataKeys.COMPUTER_RAVE_MODE, () -> this.raveMode);
        registerKeyValue(PixelmonDataKeys.COMPUTER_RAVE_MODE, this::raveMode);
    }

    @Override
    public ImmutableOptionalValue<UUID> owner() {
        return ownerValue;
    }

    @Override
    public ImmutableValue<DyeColor> color() {
        return colorValue;
    }

    @Override
    public ImmutableValue<Boolean> raveMode() {
        return raveModeValue;
    }

    @Override
    public MutableComputerTileEntityData asMutable() {
        return new PixelmonMutableComputerTileEntityData(this.owner, this.color, this.raveMode);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }
}
