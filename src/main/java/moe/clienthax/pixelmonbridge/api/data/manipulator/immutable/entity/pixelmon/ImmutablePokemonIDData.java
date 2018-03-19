package moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon.MutablePokemonIDData;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;

/**
 * Created by clienthax on 19/03/2018.
 */
public interface ImmutablePokemonIDData extends ImmutableListData<Integer, ImmutablePokemonIDData, MutablePokemonIDData> {

    ImmutableListValue<Integer> pokemonID();

}
