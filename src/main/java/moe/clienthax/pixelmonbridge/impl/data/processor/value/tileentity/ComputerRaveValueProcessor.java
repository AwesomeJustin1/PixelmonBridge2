package moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity;

import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityPC;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.processor.common.AbstractSpongeValueProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

public class ComputerRaveValueProcessor extends AbstractSpongeValueProcessor<TileEntityPC, Boolean, Value<Boolean>> {

    public ComputerRaveValueProcessor() {
        super(TileEntityPC.class, PixelmonDataKeys.COMPUTER_RAVE_MODE);
    }

    @Override
    protected Value<Boolean> constructValue(Boolean actualValue) {
        return new SpongeValue<>(getKey(), actualValue);
    }

    @Override
    protected boolean set(TileEntityPC container, Boolean value) {
        container.setRave(value);
        return true;
    }

    @Override
    protected Optional<Boolean> getVal(TileEntityPC container) {
        return Optional.of(container.getRave());
    }

    @Override
    protected ImmutableValue<Boolean> constructImmutableValue(Boolean value) {
        return new ImmutableSpongeValue<>(getKey(), value);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

}
