package moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableEggData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableEggData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableEggData;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.OptBool;
import org.spongepowered.common.data.processor.common.AbstractEntitySingleDataProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

/**
 * Created by clienthax on 13/03/2018.
 */
public class EggDataProcessor extends AbstractEntitySingleDataProcessor<EntityPixelmon, Boolean, Value<Boolean>, MutableEggData, ImmutableEggData> {

    public EggDataProcessor() {
        super(EntityPixelmon.class, PixelmonDataKeys.POKEMON_IS_EGG);
    }

    @Override
    protected boolean set(EntityPixelmon dataHolder, Boolean value) {
        dataHolder.isEgg = value;
        return true;
    }

    @Override
    protected Optional<Boolean> getVal(EntityPixelmon dataHolder) {
        return OptBool.of(dataHolder.isEgg);
    }

    @Override
    protected ImmutableValue<Boolean> constructImmutableValue(Boolean value) {
        return ImmutableSpongeValue.cachedOf(this.key, false, value);
    }

    @Override
    protected Value<Boolean> constructValue(Boolean actualValue) {
        return new SpongeValue<>(this.key, false, actualValue);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

    @Override
    protected MutableEggData createManipulator() {
        return new PixelmonMutableEggData();
    }

}
