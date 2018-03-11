package moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity;

import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityPC;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.OptionalValue;
import org.spongepowered.common.data.processor.common.AbstractSpongeValueProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeOptionalValue;
import org.spongepowered.common.data.value.mutable.SpongeOptionalValue;

import java.util.Optional;
import java.util.UUID;

public class ComputerOwnerValueProcessor extends AbstractSpongeValueProcessor<TileEntityPC, Optional<UUID>, OptionalValue<UUID>> {

    public ComputerOwnerValueProcessor() {
        super(TileEntityPC.class, PixelmonDataKeys.COMPUTER_OWNER);
    }


    @Override
    protected OptionalValue<UUID> constructValue(Optional<UUID> actualValue) {
        return new SpongeOptionalValue<>(getKey(), actualValue);
    }

    @Override
    protected boolean set(TileEntityPC container, Optional<UUID> value) {
        container.setOwner(value.orElse(null));
        return true;
    }

    @Override
    protected Optional<Optional<UUID>> getVal(TileEntityPC container) {
        return Optional.of(Optional.ofNullable(container.getOwnerUUID()));
    }

    @Override
    protected ImmutableValue<Optional<UUID>> constructImmutableValue(Optional<UUID> value) {
        return new ImmutableSpongeOptionalValue<>(getKey(), value);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

}
