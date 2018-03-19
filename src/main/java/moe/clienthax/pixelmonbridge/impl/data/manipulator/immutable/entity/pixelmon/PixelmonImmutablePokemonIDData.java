package moe.clienthax.pixelmonbridge.impl.data.manipulator.immutable.entity.pixelmon;

import com.google.common.collect.ImmutableList;
import moe.clienthax.pixelmonbridge.api.data.key.PixelmonDataKeys;
import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutablePokemonIDData;
import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutablePokemonIDData;
import moe.clienthax.pixelmonbridge.impl.data.manipulator.mutable.entity.pixelmon.PixelmonMutablePokemonIDData;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;
import org.spongepowered.common.data.manipulator.immutable.common.AbstractImmutableListData;
import org.spongepowered.common.data.value.immutable.ImmutableSpongeListValue;

import java.util.List;

/**
 * Created by clienthax on 19/03/2018.
 */
public class PixelmonImmutablePokemonIDData extends AbstractImmutableListData<Integer, ImmutablePokemonIDData, MutablePokemonIDData> implements ImmutablePokemonIDData {

    protected PixelmonImmutablePokemonIDData(List<Integer> value) {
        super(ImmutablePokemonIDData.class, value, PixelmonDataKeys.POKEMON_ID, PixelmonMutablePokemonIDData.class);
    }

    @Override
    public ImmutableListValue<Integer> pokemonID() {
        return new ImmutableSpongeListValue<>(PixelmonDataKeys.POKEMON_ID, ImmutableList.copyOf(getValue()));
    }

}