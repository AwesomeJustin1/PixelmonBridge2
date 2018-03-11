package moe.clienthax.pixelmonbridge.impl.data.processor.value.tileentity;

import com.pixelmonmod.pixelmon.blocks.tileEntities.TileEntityPC;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.processor.common.AbstractSpongeValueProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

/**
 * Created by clienthax on 10/03/2018.
 */

public class ComputerColorValueProcessor extends AbstractSpongeValueProcessor<TileEntityPC, DyeColor, Value<DyeColor>> {

    public ComputerColorValueProcessor() {
        super(TileEntityPC.class, PixelmonDataKeys.COMPUTER_COLOR);
    }

    @Override
    protected Value<DyeColor> constructValue(DyeColor actualValue) {
        return new SpongeValue<>(getKey(), actualValue);
    }

    @Override
    protected boolean set(TileEntityPC container, DyeColor value) {
        container.setColour(value.getId());
        return true;
    }

    @Override
    protected Optional<DyeColor> getVal(TileEntityPC container) {
        return Sponge.getRegistry().getType(DyeColor.class, container.getColour());
    }

    @Override
    protected ImmutableValue<DyeColor> constructImmutableValue(DyeColor value) {
        return new ImmutableSpongeValue<>(getKey(), value);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

}
