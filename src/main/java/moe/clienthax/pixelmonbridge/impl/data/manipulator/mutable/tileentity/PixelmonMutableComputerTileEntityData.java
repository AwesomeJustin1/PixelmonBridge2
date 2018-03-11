package moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.tileentity;

import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.tileentity.ImmutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.tileentity.MutableComputerTileEntityData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.tileentity.PixelmonImmutableComputerTileEntityData;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.DyeColors;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.value.mutable.SpongeOptionalValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;
import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by clienthax on 10/03/2018.
 */
public class PixelmonMutableComputerTileEntityData extends AbstractData<MutableComputerTileEntityData, ImmutableComputerTileEntityData> implements MutableComputerTileEntityData {

    Optional<UUID> owner;
    DyeColor color;
    boolean raveMode;

    public PixelmonMutableComputerTileEntityData(Optional<UUID> owner, DyeColor color, boolean raveMode) {
        this.owner = owner;
        this.color = color;
        this.raveMode = raveMode;
        registerGettersAndSetters();
    }

    public PixelmonMutableComputerTileEntityData() {
        this(Optional.empty(), DyeColors.RED, false);
    }

    @Override
    protected void registerGettersAndSetters() {
        registerFieldGetter(PixelmonDataKeys.COMPUTER_OWNER, () -> this.owner);
        registerFieldSetter(PixelmonDataKeys.COMPUTER_OWNER, (value) -> this.owner = value);
        registerKeyValue(PixelmonDataKeys.COMPUTER_OWNER, this::owner);

        registerFieldGetter(PixelmonDataKeys.COMPUTER_COLOR, () -> this.color);
        registerFieldSetter(PixelmonDataKeys.COMPUTER_COLOR, (value) -> this.color = value);
        registerKeyValue(PixelmonDataKeys.COMPUTER_COLOR, this::color);

        registerFieldGetter(PixelmonDataKeys.COMPUTER_RAVE_MODE, () -> this.raveMode);
        registerFieldSetter(PixelmonDataKeys.COMPUTER_RAVE_MODE, (value) -> this.raveMode = value);
        registerKeyValue(PixelmonDataKeys.COMPUTER_RAVE_MODE, this::raveMode);
    }

    @Override
    public OptionalValue<UUID> owner() {
        return new SpongeOptionalValue<>(PixelmonDataKeys.COMPUTER_OWNER, this.owner);
    }

    @Override
    public Value<DyeColor> color() {
        return new SpongeValue<>(PixelmonDataKeys.COMPUTER_COLOR, this.color);
    }

    @Override
    public Value<Boolean> raveMode() {
        return new SpongeValue<>(PixelmonDataKeys.COMPUTER_RAVE_MODE, this.raveMode);
    }


    @Override
    public Optional<MutableComputerTileEntityData> fill(DataHolder dataHolder, MergeFunction overlap) {
        MutableComputerTileEntityData mutableBaseStatsData = checkNotNull(checkNotNull(overlap).merge(copy(), from(dataHolder.toContainer()).orElse(null)));
        mutableBaseStatsData = mutableBaseStatsData
                .set(PixelmonDataKeys.COMPUTER_OWNER, this.owner)
                .set(PixelmonDataKeys.COMPUTER_COLOR, this.color)
                .set(PixelmonDataKeys.COMPUTER_RAVE_MODE, this.raveMode);
        return Optional.of(mutableBaseStatsData);
    }

    @Override
    public Optional<MutableComputerTileEntityData> from(DataContainer container) {
        return Optional.empty();
    }

    @Override
    public MutableComputerTileEntityData copy() {
        return new PixelmonMutableComputerTileEntityData(this.owner, this.color, this.raveMode);
    }

    @Override
    public ImmutableComputerTileEntityData asImmutable() {
        return new PixelmonImmutableComputerTileEntityData(this.owner, this.color, this.raveMode);
    }

    @Override
    public int getContentVersion() {
        return 0;
    }
}
