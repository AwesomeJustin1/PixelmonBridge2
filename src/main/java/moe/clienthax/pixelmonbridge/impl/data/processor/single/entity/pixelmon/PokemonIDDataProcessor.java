package moe.clienthax.pixelmonbridge.impl.data.processor.single.entity.pixelmon;

import com.google.common.primitives.Ints;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutablePokemonIDData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutablePokemonIDData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutablePokemonIDData;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.common.data.processor.common.AbstractEntitySingleDataProcessor;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeListValue;
import org.spongepowered.common.data.value.mutable.SpongeListValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by clienthax on 19/03/2018.
 */
public class PokemonIDDataProcessor extends AbstractEntitySingleDataProcessor<EntityPixelmon, List<Integer>, ListValue<Integer>, MutablePokemonIDData, ImmutablePokemonIDData> {

    public PokemonIDDataProcessor() {
        super(EntityPixelmon.class, PixelmonDataKeys.POKEMON_ID);
    }

    @Override
    protected boolean set(EntityPixelmon dataHolder, List<Integer> value) {
        if(value.size() != 2)//Range check
            return false;
        dataHolder.setPokemonId(Ints.toArray(value));
        return true;
    }

    @Override
    protected Optional<List<Integer>> getVal(EntityPixelmon dataHolder) {
        List<Integer> ids = new ArrayList<>(2);
        ids.add(dataHolder.getPokemonId()[0]);
        ids.add(dataHolder.getPokemonId()[1]);
        return Optional.of(ids);
    }

    @Override
    protected ImmutableValue<List<Integer>> constructImmutableValue(List<Integer> value) {
        return ImmutableSpongeListValue.cachedOf(this.key, new ArrayList<>(2), value);
    }

    @Override
    protected ListValue<Integer> constructValue(List<Integer> actualValue) {
        return new SpongeListValue<>(this.key, new ArrayList<>(2), actualValue);
    }

    @Override
    public DataTransactionResult removeFrom(ValueContainer<?> container) {
        return DataTransactionResult.failNoData();
    }

    @Override
    protected MutablePokemonIDData createManipulator() {
        return new PixelmonMutablePokemonIDData();
    }

}
