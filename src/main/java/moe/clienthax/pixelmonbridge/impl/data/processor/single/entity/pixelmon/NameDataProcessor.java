package moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon;

import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutableNameData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutableNameData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutableNameData;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.common.data.processor.common.AbstractEntitySingleDataProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeValue;
import org.spongepowered.common.data.value.mutable.SpongeValue;

import java.util.Optional;

/**
 * Created by clienthax on 13/03/2018.
 */
public class NameDataProcessor extends AbstractEntitySingleDataProcessor<EntityPixelmon, String, Value<String>, MutableNameData, ImmutableNameData> {

    public NameDataProcessor() {
        super(EntityPixelmon.class, PixelmonDataKeys.POKEMON_NAME);
    }

    @Override
    protected boolean set(EntityPixelmon dataHolder, String value) {//TODO sanity check for enumpokemon?
        dataHolder.setName(value);
        return true;
    }

    @Override
    protected Optional<String> getVal(EntityPixelmon dataHolder) {
        return Optional.of(dataHolder.getPokemonName());
    }

    @Override
    protected ImmutableValue<String> constructImmutableValue(String value) {
        return ImmutableSpongeValue.cachedOf(this.key, "", value);
    }

    @Override
    protected Value<String> constructValue(String actualValue) {
        return new SpongeValue<>(this.key, "", actualValue);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

    @Override
    protected MutableNameData createManipulator() {
        return new PixelmonMutableNameData();
    }
}
