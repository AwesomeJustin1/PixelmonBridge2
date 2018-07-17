package moe.clienthax.pixelmonbridge.api.data.manipulator.mutable.entity.pixelmon;

import moe.clienthax.pixelmonbridge.api.data.manipulator.immutable.entity.pixelmon.ImmutablePokemonIDData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.entity.living.player.Player;

/**
 * Created by clienthax on 19/03/2018.
 */
public interface MutablePokemonIDData extends ListData<Integer, MutablePokemonIDData, ImmutablePokemonIDData> {

    ListValue<Integer> pokemonID();

    void setAsPlayerPokemon(Player player);

}
